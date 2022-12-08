package amazon.products;

import amazon.utils.PropertiesParser;

import java.util.Objects;

public class Television extends Product {
    public Television() {}

    private Television(TelevisionBuilder builder) {
        this.productTitle = builder.productTitle;
        this.actualPrice = builder.actualPrice;
    }

    public static class TelevisionBuilder {
        private String productTitle;
        private String actualPrice;

        public TelevisionBuilder setTelevisionTitle(String productTitle) {
            this.productTitle = productTitle;
            return this;
        }

        public TelevisionBuilder setPrice(String actualPrice) {
            this.actualPrice = actualPrice;
            return this;
        }

        public Television build() {
            return new Television(this);
        }
    }

    public static Television getExpectedTelevision(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new TelevisionBuilder()
                .setTelevisionTitle(listOfProperties[0])
                .setPrice(listOfProperties[1])
                .build();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", price='" + actualPrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television television = (Television) o;
        return Objects.equals(productTitle, television.productTitle) && Objects.equals(actualPrice, television.actualPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTitle, actualPrice);
    }
}
