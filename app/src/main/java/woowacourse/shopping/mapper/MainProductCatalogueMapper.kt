package woowacourse.shopping

import com.shopping.domain.MainProductCatalogue
import woowacourse.shopping.mapper.toDomain
import woowacourse.shopping.mapper.toUIModel
import woowacourse.shopping.productcatalogue.list.MainProductCatalogueUIModel

fun MainProductCatalogueUIModel.toDomain(): MainProductCatalogue =
    MainProductCatalogue(items.map { it.toDomain() })

fun MainProductCatalogue.toUIModel(): MainProductCatalogueUIModel =
    MainProductCatalogueUIModel(items.map { it.toUIModel() })
