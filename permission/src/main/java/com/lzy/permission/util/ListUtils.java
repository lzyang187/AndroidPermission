package com.lzy.permission.util;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: cyli8
 * @date: 2018/7/30 17:37
 */
public class ListUtils {
    public ListUtils() {
    }

    public static <T> int size(List<T> list) {
        return null == list ? 0 : list.size();
    }

    public static <T> boolean isIndexValid(List<T> list, int index) {
        if (null == list) {
            return false;
        } else {
            return index >= 0 && index < list.size();
        }
    }

    public static int size(List... lists) {
        int count = 0;
        List[] var2 = lists;
        int var3 = lists.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            List<?> l = var2[var4];
            count += size(l);
        }

        return count;
    }

    public static <T> int size(T... list) {
        return null == list ? 0 : list.length;
    }

    public static <T> boolean isEmpty(List<T> list) {
        return null == list ? true : list.isEmpty();
    }

    public static boolean isEmpty(List... lists) {
        if (null == lists) {
            return true;
        } else {
            List[] var1 = lists;
            int var2 = lists.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                List<?> l = var1[var3];
                if (isNotEmpty(l)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static <T> boolean isEmpty(T[] list) {
        if (null == list) {
            return true;
        } else {
            return list.length == 0;
        }
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }

    public static <T> boolean isNotEmpty(T[] list) {
        return !isEmpty(list);
    }

    public static boolean isNotEmpty(Map map) {
        return null != map && map.size() > 0;
    }

    public static boolean isNotEmpty(Set map) {
        return null != map && map.size() > 0;
    }

    public static boolean isNotEmpty(SparseArray array) {
        return null != array && array.size() > 0;
    }

    public static <T> boolean isEmpty2(T... list) {
        return list == null || list.length == 0;
    }

    public static <T> boolean isNotEmpty2(T... list) {
        return !isEmpty2(list);
    }

    public static <T> T getItem(List<T> list, int pos) {
        if (null == list) {
            return null;
        } else {
            int size = list.size();
            return pos >= 0 && pos < size ? list.get(pos) : null;
        }
    }

    public static <T> boolean indexIn(List<T> list, int index) {
        if (null == list) {
            return false;
        } else {
            return index >= 0 && index < list.size();
        }
    }

    public static <T> List<T> copy(List<T> arr) {
        int size = size(arr);
        ArrayList<T> ret = new ArrayList(size);
        if (size > 0) {
            ret.addAll(arr);
        }

        return ret;
    }

    public static <T> List<T> newList(List<T> list) {
        if (null == list) {
            return new ArrayList();
        } else {
            list.clear();
            return list;
        }
    }
}
