package com.theoxao.duraemon.recipe.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


@Configuration
@ConfigurationProperties(prefix = "spring.datasource.slave")
class SlaveDatasourceConfiguration: HikariConfig(){
    @Bean(name = ["slaveDataSource"])

    fun slaveDataSource(): DataSource {
        return HikariDataSource(this)
    }

    @Bean(name = ["slaveDSLContext"])
    @Throws(Exception::class)
    fun slaveSqlSessionFactory(@Qualifier("slaveDataSource") dataSource: DataSource): DSLContext? {
        return DSL.using(dataSource, SQLDialect.POSTGRES)
    }

    @Bean(name =["slaveTransactionManager"])
    fun slaveTransactionManager(@Qualifier("slaveDataSource") dataSource: DataSource): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}