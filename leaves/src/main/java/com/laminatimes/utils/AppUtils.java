package com.laminatimes.utils;

import com.laminatimes.exception.LeavesException;


public class AppUtils {
	public static void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new LeavesException("Page number cannot be less than zero.");
        }

        if(size < 0) {
            throw new LeavesException( "Size number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
        	throw new LeavesException( "Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}
