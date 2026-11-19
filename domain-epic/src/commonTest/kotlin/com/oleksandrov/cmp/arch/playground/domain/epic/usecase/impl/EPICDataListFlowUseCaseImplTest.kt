package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.mock
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class EPICDataListFlowUseCaseImplTest {
    private val repository = mock<EPICRepository>()
    private val useCase = EPICDataListFlowUseCaseImpl(repository)

    @Test
    fun invoke_emits_mapped_domain_models_when_repository_emits_data() {
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
            every { repository.dataList } returns flowOf(repoList)

            val results = useCase().toList()

            assertEquals(1, results.size)
            val domainModels = results[0]
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
    fun invoke_emits_null_when_repository_emits_null() {
        runBlocking {
            every { repository.dataList } returns flowOf(null)

            val results = useCase().toList().firstOrNull()

            assertNull(results)
        }
    }

    @Test
    fun invoke_emits_empty_list_when_repository_emits_empty_list() {
        runBlocking {
            every { repository.dataList } returns flowOf(emptyList())

            val results = useCase().toList().firstOrNull()

            assertEquals(0, results?.size)
            assertNotNull(results)
            assertTrue(results.isEmpty())
        }
    }

    @Test
    fun invoke_emits_multiple_values_when_repository_emits_multiple_values() {
        runBlocking {
            val repoList1 = listOf(
                EPICRepoModel(
                    identifier = "1",
                    caption = "Test 1",
                    image = "img1",
                    date = "2023-01-01",
                )
            )
            val repoList2 = listOf(
                EPICRepoModel(
                    identifier = "2",
                    caption = "Test 2",
                    image = "img2",
                    date = "2023-01-02",
                )
            )
            every { repository.dataList } returns flowOf(null, repoList1, repoList2)

            val results = useCase().toList()

            assertEquals(3, results.size)
            assertNull(results[0])

            assertNotNull(results[1])
            assertEquals(1, results[1]?.size)
            assertEquals("1", results[1]?.get(0)?.identifier)

            assertNotNull(results[2])
            assertEquals(1, results[2]?.size)
            assertEquals("2", results[2]?.get(0)?.identifier)
        }
    }
}
