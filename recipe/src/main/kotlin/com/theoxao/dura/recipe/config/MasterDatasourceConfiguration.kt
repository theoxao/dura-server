package com.theoxao.dura.recipe.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


@Configuration
@ConfigurationProperties(prefix = "spring.datasource.master")
class MasterDatasourceConfiguration : HikariConfig() {

    @Bean(name = ["masterDataSource"])
    @Primary
    fun masterDataSource(): DataSource {
        return HikariDataSource(this)
    }

    @Bean(name = ["masterDSLContext"])
    @Primary
    @Throws(Exception::class)
    fun masterDslContext(@Qualifier("masterDataSource") dataSource: DataSource): DSLContext {
        return DSL.using(dataSource, SQLDialect.POSTGRES)
    }

    @Bean(name = ["masterTransactionManager"])
    @Primary
    fun masterTransactionManager(@Qualifier("masterDataSource") dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

}