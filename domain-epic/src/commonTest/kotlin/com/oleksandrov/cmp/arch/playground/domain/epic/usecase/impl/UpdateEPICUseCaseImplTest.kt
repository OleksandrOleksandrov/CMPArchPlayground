package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.common.exception.ConnectionApiException
import com.oleksandrov.cmp.arch.playground.common.exception.ServerErrorApiException
import com.oleksandrov.cmp.arch.playground.common.exception.TimeoutApiException
import com.oleksandrov.cmp.arch.playground.common.exception.UnknownApiException
import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.NetworkException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.ServerException
import com.oleksandrov.cmp.arch.playground.domain.epic.exception.UnknownException
import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class UpdateEPICUseCaseImplTest {

    private val repository = mock<EPICRepository>()
    private val useCase = UpdateEPICUseCaseImpl(repository)

    @Test
    fun invoke_returns_success_with_mapped_domain_models_when_repository_returns_data() {
        runBlocking {
            val repoList = listOf(
                EPICRepoModel(
                    identifier = "1",
                    caption = "Test 1",
                    image = "img1",
                    date = "2023-01-01",
                ),
                EPICRepoModel(
                    identifier = "2",
                    caption = "Test 2",
                    image = "img2",
                    date = "2023-01-02",
                ),
            )
            everySuspend { repository.fetchData() } returns repoList

            val result = useCase()

            assertTrue(result.isSuccess)
            val domainModels = result.getOrNull()
            assertNotNull(domainModels)
            assertEquals(2, domainModels.size)

            assertEquals("1", domainModels[0].identifier)
            assertEquals("Test 1", domainModels[0].caption)
            assertEquals("img1", domainModels[0].image)
            assertEquals("2023-01-01", domainModels[0].date)

            assertEquals("2", domainModels[1].identifier)
            assertEquals("Test 2", domainModels[1].caption)
            assertEquals("img2", domainModels[1].image)
            assertEquals("2023-01-02", domainModels[1].date)
        }
    }

    @Test
    fun invoke_returns_success_with_null_when_repository_returns_null() {
        runBlocking {
            everySuspend { repository.fetchData() } returns null

            val result = useCase()

            assertTrue(result.isSuccess)
            assertNull(result.getOrNull())
        }
    }

    @Test
    fun invoke_returns_success_with_empty_list_when_repository_returns_empty_list() {
        runBlocking {
            everySuspend { repository.fetchData() } returns emptyList()

            val result = useCase()

            assertTrue(result.isSuccess)
            val domainModels = result.getOrNull()
            assertNotNull(domainModels)
            assertTrue(domainModels.isEmpty())
        }
    }

    @Test
    fun invoke_returns_failure_with_ServerException_when_ServerErrorApiException_occurs() {
        runBlocking {
            everySuspend { repository.fetchData() } throws ServerErrorApiException(
                error = "Internal Server Error",
                statusCode = 500,
                statusMessage = "Error"
            )

            val result = useCase()

            assertTrue(result.isFailure)
            assertIs<ServerException>(result.exceptionOrNull())
        }
    }

    @Test
    fun invoke_returns_failure_with_NetworkException_when_ConnectionApiException_occurs() {
        runBlocking {
            everySuspend { repository.fetchData() } throws ConnectionApiException(RuntimeException("No connection"))

            val result = useCase()

            assertTrue(result.isFailure)
            assertIs<NetworkException>(result.exceptionOrNull())
        }
    }

    @Test
    fun invoke_returns_failure_with_NetworkException_when_TimeoutApiException_occurs() {
        runBlocking {
            everySuspend { repository.fetchData() } throws TimeoutApiException()

            val result = useCase()

            assertTrue(result.isFailure)
            assertIs<NetworkException>(result.exceptionOrNull())
        }
    }

    @Test
    fun invoke_returns_failure_with_NetworkException_when_UnknownApiException_occurs() {
        runBlocking {
            everySuspend { repository.fetchData() } throws UnknownApiException()

            val result = useCase()

            assertTrue(result.isFailure)
            assertIs<NetworkException>(result.exceptionOrNull())
        }
    }

    @Test
    fun invoke_returns_failure_with_UnknownException_when_generic_Exception_occurs() {
        runBlocking {
            everySuspend { repository.fetchData() } throws RuntimeException("Unexpected error")

            val result = useCase()

            assertTrue(result.isFailure)
            assertIs<UnknownException>(result.exceptionOrNull())
        }
    }
}
