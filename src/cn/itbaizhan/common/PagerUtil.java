package cn.itbaizhan.common;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class PagerUtil {
	// 每页显示5条
	private static int pagerSize = 5;

	public static List<?> getPager(List<?> list, int pagerNumber) {
		// 璧峰椤�
		int start = (pagerNumber - 1) * pagerSize;
		// 缁撴潫椤�
		int end = pagerNumber * pagerSize;

		List newlist = new ArrayList();

		int max = 0;
		if (end > list.size()) {
			max = list.size();
		} else {
			max = end;
		}

		for (int i = start; i < max; i++) {
			newlist.add(list.get(i));
		}
		return newlist;

	}

	// 得到总页数
	public static int getMaxPager(int total) {
		int maxPager = (int) Math.ceil((total * 1.0) / pagerSize);
		return maxPager;
	}

	public static void main(String[] args) {
		int total = 20;
		int size = 8;
		int pageCount = (int) Math.ceil((total * 1.0) / size);
		System.out.println(pageCount);
	}
}
