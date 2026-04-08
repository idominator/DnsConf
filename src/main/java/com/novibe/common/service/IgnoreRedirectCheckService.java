package com.novibe.common.service;

import com.novibe.common.data_sources.IgnoreRedirectSettingsLoader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IgnoreRedirectCheckService {

    private final List<String> ignoringList;

    public IgnoreRedirectCheckService(IgnoreRedirectSettingsLoader ignoreRedirectSettingsLoader) {
        ignoringList = ignoreRedirectSettingsLoader.loadIgnoredDomains();
    }

    public boolean shouldIgnore(String domain) {
        for (String ignored : ignoringList) {
            if (domain.endsWith(ignored)) {
                return true;
            }
        }
        return false;
    }

}
