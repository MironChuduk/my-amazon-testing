package cucumber;

import amazon.pages.giftCardsPage.GiftCard;
import amazon.services.GiftCardsService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class GiftCardsSteps {
    private GiftCardsService giftCardsService;

    @Then("I choose format {string}")
    public void chooseFormat(String formatName) {
        giftCardsService = new GiftCardsService();
        giftCardsService.chooseFormat(formatName);
    }

    @And("I choose brand {string}")
    public void chooseBrand(String brandName) {
        giftCardsService = new GiftCardsService();
        giftCardsService.chooseBrand(brandName);
    }

    @And("I choose price {string}")
    public void choosePrice(String price) {
        giftCardsService = new GiftCardsService();
        giftCardsService.choosePrice(price);
    }

    @And("I sort by {string}")
    public void sort(String sortArgument) {
        giftCardsService = new GiftCardsService();
        giftCardsService.sort(sortArgument);
    }

    @Then("Verify first 4 Gift Cards")
    public void verify() {
        giftCardsService = new GiftCardsService();
        List<String> keys = Arrays.asList("item1", "item2", "item3", "item4");
        List<GiftCard> expectedProductList = GiftCard.getExpectedGiftCards(keys);
        List<GiftCard> actualProductList = giftCardsService.getGiftCardList();
        Assert.assertEquals(actualProductList, expectedProductList);
        Assert.assertTrue(Integer
                .parseInt(actualProductList.get(0).getMinPrice()) <= Integer
                .parseInt(actualProductList.get(3).getMinPrice()));

    }
}
