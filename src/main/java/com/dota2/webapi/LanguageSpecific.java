package com.dota2.webapi;

import com.dota2.config.ApiProperties;
import com.dota2.service.WebService;

import java.util.Locale;

import static com.dota2.util.Validation.checkNotNull;

abstract class LanguageSpecific<U extends ApiProperties.BaseRequestConfig, T extends LanguageSpecific> extends ApiRequest<U> {

        LanguageSpecific(U requestConfig, WebService webService) {
        super(requestConfig, webService);
    }

    public T language(final Locale locale) {
        return language(locale.getLanguage());
    }

    @SuppressWarnings("unchecked") //This works ok since T will be set to the same type as this
    public T language(final String language) {
        checkNotNull(language);

        getQueryParams().put(getRequestConfig().getLanguageParam(), language);
        return (T) this;
    }
}
