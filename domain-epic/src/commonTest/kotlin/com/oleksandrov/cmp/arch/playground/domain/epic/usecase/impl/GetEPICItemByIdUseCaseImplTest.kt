package com.oleksandrov.cmp.arch.playground.domain.epic.usecase.impl

import com.oleksandrov.cmp.arch.playground.data.epic.model.EPICRepoModel
import com.oleksandrov.cmp.arch.playground.data.epic.repository.EPICRepository
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GetEPICItemByIdUseCaseImplTest {
    private val repository = mock<EPICRepository>()
    private val useCase = GetEPICItemByIdUseCaseImpl(repository)

    @Test
    fun invoke_returns_success_with_mapped_domain_model_when_repository_returns_data() {
        runBlocking {
            val repoModel = EPICRepoModel(
                identifier = "1",
                caption = "Test 1",
                image = "img1",
                date = "2023-01-01",
            )

            everySuspend { repository.getEpicById(any()) } returns repoModel
            val result = useCase("1")
            val domainModel = result.getOrNull()
            assertNotNull(domainModel)

            assertEquals("1", domainModel.identifier)
            assertEquals("Test 1", domainModel.caption)
            assertEquals("img1", domainModel.image)
            assertEquals("2023-01-01", domainModel.date)
        }
    }
}