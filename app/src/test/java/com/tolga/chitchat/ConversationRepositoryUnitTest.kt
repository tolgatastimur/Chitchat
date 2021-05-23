package com.tolga.chitchat

import com.tolga.chitchat.domain.MeditopiaApi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit

class ConversationRepositoryUnitTest {

    lateinit var mockServer: MockWebServer
    lateinit var apiService: MeditopiaApi

    @Before
    @Throws
    fun setUp() {
        mockServer = MockWebServer()
        mockServer.start()

        // Get an instance of Retrofit
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Get an instance of apiService
        apiService = retrofit.create(MeditopiaApi::class.java)
    }

    @Test
    fun chatData_parseCorrefctly() {
        mockServer.apply {
            enqueue(MockResponse()
                    .setResponseCode(200)
                    .setBody(InputStreamReader(javaClass.classLoader.getResourceAsStream("mock_chatdata.json")).readText())
            )
        }

        apiService.getChatdata()
                .test()
                .awaitDone(3, TimeUnit.SECONDS)
                .assertComplete()
                .assertValueCount(1)
                .assertNoErrors()

    }

    @After
    @Throws
    fun tearDown() {
        // We're done with tests, shut it down
        mockServer.shutdown()
    }
}