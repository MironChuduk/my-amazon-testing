package amazon.services;

import amazon.pages.giftCardsPage.GiftCard;
import amazon.pages.giftCardsPage.GiftCardsPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GiftCardsService {
    private GiftCardsPage giftCardsPage;

    public void chooseFormat(String formatName) {
        giftCardsPage = new GiftCardsPage();
        giftCardsPage.clickOnFormatCheckbox(formatName);
    }

    public void chooseBrand(String brandName) {
        giftCardsPage = new GiftCardsPage();
        giftCardsPage.clickOnBrandName(brandName);
    }

    public void choosePrice(String price) {
        giftCardsPage = new GiftCardsPage();
        giftCardsPage.clickOnPrice(price);
    }

    public void sort(String sortArgument) {
        giftCardsPage = new GiftCardsPage();
        giftCardsPage.clickToSort();
        giftCardsPage.sort(sortArgument);
    }

    public GiftCard getGiftCard(WebElement parentElement) {
        giftCardsPage = new GiftCardsPage();
        String giftCardTitle = giftCardsPage.getTitle(parentElement);
        String giftCardMinPrice = giftCardsPage.getMinPrice(parentElement);
        return new GiftCard.GiftCardBuilder()
                .setCardTitle(giftCardTitle)
                .setMinPrice(giftCardMinPrice)
                .build();
    }

    public List<GiftCard> getGiftCardList() {
        giftCardsPage = new GiftCardsPage();
        return giftCardsPage.getResultItems().stream()
                .limit(4).map(this::getGiftCard).collect(Collectors.toList());
    }
}
