package com.example.newsapi

import com.example.newsapi.model.ResponseDataSource
import com.example.newsapi.model.Source
import com.example.newsapi.network.ApiService

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Call

class SourceViewModelTest {
    lateinit var service: ApiService

    @Before
    fun setUp() {
        service = mockk()
    }

    @Test
    fun testRetriveData(): Unit = runBlocking {
        val responseRetrive = mockk<Call<ResponseDataSource>>()

        every{
            runBlocking {
                service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        } returns responseRetrive
        val result = service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")

        verify {
            runBlocking {
                service.getAllSources("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        }


        assertEquals(result,responseRetrive)


    }
}