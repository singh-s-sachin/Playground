package lld;

import java.math.BigDecimal;
import java.util.List;

public class RecommendationEngine {
    // Category, Product(Reviews, Price)
    public static List<ProductCategory> getProductCategory(String productID) {
        return null;
    }
}

class MappedCategory {
    String productID;
    public List<Integer> getFilteredCategory() {
        return null;
    }
}

class ProductCategory {
    int categoryCode;

    public List<Product> getFilteredProducts(Filter reviewFilter, Filter priceFiler) {
        return null;
    }
}

class Product {
    String productID;
    double productReview;
    BigDecimal price;
}

enum Filter {
    BEST, ANY
}
/**
 * ProductTable
 * ProdID, Review, Price
 * <p>
 * MappedCategory
 * CategoryCode, ProductID, CreatedTime, LastModifiedTime
 * <p>
 * ProductCategory
 * ProductID,CategoryCode,CreatedTime,LastModifiedTime
 *
 * Adds a product to a cart => PID
 * MappedCategory(ProductID) => List<ProductCategory> (productcategories) => Fiter
 * productcategories.forEach => ProductIDs (to be recommended based on price and review filter)
 * Add it to the recommendation page
 */