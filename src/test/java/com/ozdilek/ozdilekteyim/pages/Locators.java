package com.ozdilek.ozdilekteyim.pages;

public enum Locators {
    HOMEPAGE_CHECK("com.ozdilek.ozdilekteyim:id/cl_orangeFilter"),
    ALISVERISE_BASLA("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore"),
    SHOPPINGPAGE_CHECK("//*[@class='androidx.recyclerview.widget.RecyclerView']//*[@class='androidx.recyclerview.widget.RecyclerView']//*[@class='android.widget.FrameLayout'][1]//*[@class='android.widget.LinearLayout']//*[@class='android.widget.TextView']"),

    CATEGORYPAGE("com.ozdilek.ozdilekteyim:id/nav_categories"),
    CATEGORY_CHECK("//*[@content-desc='Kategoriler']"),

    KADIN_CATEGORY_SELECT("//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayCategoriesItem'][2]"),

    PANTOLON_SELECT("//android.widget.RelativeLayout[@index='13']"),
    PANTOLON_CHECK("com.ozdilek.ozdilekteyim:id/relLayFilter"),

    PRODUCTS_CHECK("com.ozdilek.ozdilekteyim:id/recyclerView"),

    PRDUCTSLIST("//android.widget.ImageView[@resource-id='com.ozdilek.ozdilekteyim:id/imageView']"),
    PRODUCTCHECK("com.ozdilek.ozdilekteyim:id/tvSizeDesc"),
    PRODUCTCHOOSESIZE("//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[@index=0]"),
    PRODUCTNAME("com.ozdilek.ozdilekteyim:id/tvItemDescription"),
    PRODUCTADDFAVORITES("com.ozdilek.ozdilekteyim:id/relLayAddFav"),
    LOGINPAGE("com.ozdilek.ozdilekteyim:id/clContainer"),
    INSERT_EMAIL("com.ozdilek.ozdilekteyim:id/etEposta"),
    INSERT_PASSWORD("com.ozdilek.ozdilekteyim:id/etPassword"),
    GOBACK_BUTTON("com.ozdilek.ozdilekteyim:id/ivBack"),
    ADDTOBASKET("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn"),
    LOGINCHECK("com.ozdilek.ozdilekteyim:id/btnLogin")
    ;

    private String locators;
    Locators(String selection) {
        this.locators = selection;
    }

    public String getLocator() {
        return locators;
    }
}
