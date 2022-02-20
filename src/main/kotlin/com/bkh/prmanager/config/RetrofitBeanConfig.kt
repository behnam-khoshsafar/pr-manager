package com.bkh.prmanager.config

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.interceptor.GithubClientInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


@Configuration
class RetrofitBeanConfig(val githubClientInterceptor: GithubClientInterceptor) {

    @Bean
    fun githubClient(): GithubClient {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .client(okHttpClient())
            .build()
        return retrofit.create(GithubClient::class.java)
    }

    private fun okHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(githubClientInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

}