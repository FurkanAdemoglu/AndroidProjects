package com.example.hiltmvvmmvi.room

import com.example.hiltmvvmmvi.model.Blog
import com.example.hiltmvvmmvi.retrofit.BlogNetworkEntity
import com.example.hiltmvvmmvi.util.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor():EntityMapper<BlogCacheEntity, Blog> {
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id=entity.fid,
            title= entity.title,
            body = entity.body,
            image = entity.fimage,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            fid=domainModel.id,
            title= domainModel.title,
            body = domainModel.body,
            fimage = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entites:List<BlogCacheEntity>):List<Blog>{
        return entites.map { mapFromEntity(it) }
    }

}