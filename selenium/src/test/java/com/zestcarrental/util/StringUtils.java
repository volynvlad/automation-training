package com.zestcarrental.util;

public class StringUtils {
    public static final String HOMEPAGE_URL = "https://www.zestcarrental.com/";

    public static final String QUOTE_DATES_URL = "https://www.zestcarrental.com/quote/dates/";

    public static final String QUOTE_RESULTS_URL = "https://www.zestcarrental.com/quote/results/";

    public static final String BOOKING_EXTRAS_URL = "https://www.zestcarrental.com/booking/extras/";

    public static final String[] MONTHS =  {"january", "february", "march", "april", "may", "june",
                                                    "july", "august", "september", "october", "november", "december"};

    public static final String ERROR_MESSAGE_BOOK_DATE_ORDER = "The end date must be after the start date.";

    public static final String ERROR_MESSAGE_TIME = "Sorry, it is too late to make this booking online. Currently we require 17 hours notice to make a booking.";

    public static final String ERROR_MESSAGE_BOOK_TOO_LONG = "There are no vehicles available for a rental duration longer than 60 days.";

    public static final String ERROR_MESSAGE_TOO_SMALL_DRIVER_AGE = "There are no vehicles available for a driver of age 24.";

    public static final String CURRENCY_EUR = "EUR (€)";

    public static final String CURRENCY_GBP = "GBP (£)";

    public static final String ERROR_MESSAGE_VALID_CARD = "Please enter a valid card number.";
}
