package br.com.fabianofda.todolist.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target){
        BeanUtils.copyProperties(source, target, getNullPropetyNames(source));
    }

    public static String[] getNullPropetyNames(Object source){
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> empytNames = new HashSet<>();

        for(PropertyDescriptor pd: pds){
          Object srcValue =  src.getPropertyValue(pd.getName());
          if (srcValue == null){
              empytNames.add(pd.getName());
          }
        }

        String[] result = new String[empytNames.size()];
        return empytNames.toArray(result);
    }
}
