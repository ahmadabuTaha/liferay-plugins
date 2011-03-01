/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledgebase.util.comparator;

import com.liferay.knowledgebase.model.Template;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class TemplateTitleComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "title ASC";

	public static String ORDER_BY_DESC = "title DESC";

	public static String[] ORDER_BY_FIELDS = {"title"};

	public TemplateTitleComparator() {
		this(false);
	}

	public TemplateTitleComparator(boolean ascending) {
		_ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		Template template1 = (Template)obj1;
		Template template2 = (Template)obj2;

		int value = template1.getTitle().toLowerCase().compareTo(
			template2.getTitle().toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}