package amazon.products;

import amazon.utils.PropertiesParser;

import java.util.Objects;

public class Product {
    private String title;
    private String price;

    Product(Product product) {
        title = product.title;
        price = product.price;
    }

    Product() {
    }


    public final String getTitle() {
        return title;
    }

    public final String getPrice() {
        return price;
    }


    final void setTitle(String title) {
        this.title = title;
    }

    final void setPrice(String price) {
        this.price = price;
    }

    abstract static class PBuilder<P extends Product, B extends PBuilder<P, B>> {

        final P product;

        PBuilder(P product) {
            this.product = product;
        }

        public final B title(String title) {
            product.setTitle(title);
            return self();
        }

        public final B price(String price) {
            product.setPrice(price);
            return self();
        }

        @SuppressWarnings("unchecked")
        final B self() {
            return (B) this;
        }

    }

    public static final class Builder extends PBuilder<Product, Builder> {

        public Builder() {
            super(new Product());
        }

        public Builder(Product product) {
            super(new Product(product));
        }

        public Product build() {
            return new Product(product);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getPrice(), product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }
}