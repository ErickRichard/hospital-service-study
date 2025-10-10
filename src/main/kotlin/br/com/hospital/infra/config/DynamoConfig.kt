package br.com.hospital.infra.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsCredentials
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI


@Configuration
class DynamoConfig {
    @Bean
    fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient =
        DynamoDbEnhancedClient.builder().dynamoDbClient(DynamoDbClient.builder().credentialsProvider {
            object : AwsCredentials {
                override fun accessKeyId(): String {
                    return "local"
                }

                override fun secretAccessKey(): String {
                    return "local"
                }
            }
        }
            .region(Region.US_EAST_1)
            .endpointOverride(URI.create("http://localhost:4566"))
            .build())
            .build()
}