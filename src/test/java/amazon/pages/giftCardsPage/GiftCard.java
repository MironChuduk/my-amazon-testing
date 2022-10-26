package amazon.pages.giftCardsPage;

import amazon.utils.PropertiesParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GiftCard {
    public String getCardTitle() {
        return cardTitle;
    }

    public String getMinPrice() {
        return minPrice;
    }

    private final String cardTitle;
    private final String minPrice;

    private GiftCard(GiftCardBuilder builder) {
        this.cardTitle = builder.cardTitle;
        this.minPrice = builder.minPrice;
    }

    public static class GiftCardBuilder {
        private String cardTitle;
        private String minPrice;

        public GiftCardBuilder setCardTitle(String cardTitle) {
            this.cardTitle = cardTitle;
            return this;
        }

        public GiftCardBuilder setMinPrice(String minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public GiftCard build() {
            return new GiftCard(this);
        }
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "cardTitle='" + cardTitle + '\'' +
                ", minPrice='" + minPrice + '\'' +
                '}';
    }

    public static List<GiftCard> getExpectedProduct(List<String> keys) {
        PropertiesParser propertiesParser = new PropertiesParser();
        List<GiftCard> expectedProductList = new ArrayList<>();
        for (String key : keys) {
            String[] listOfProperties = propertiesParser.parsProperties(key);
            GiftCard product = new GiftCard.GiftCardBuilder()
                    .setCardTitle(listOfProperties[0])
                    .setMinPrice(listOfProperties[1])
                    .build();
            expectedProductList.add(product);
        }
        return expectedProductList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCard giftCard = (GiftCard) o;
        return Objects.equals(cardTitle, giftCard.cardTitle) && Objects.equals(minPrice, giftCard.minPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardTitle, minPrice);
    }
}
