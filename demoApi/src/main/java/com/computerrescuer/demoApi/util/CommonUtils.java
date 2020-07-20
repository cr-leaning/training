package com.computerrescuer.demoApi.util;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 共通メソッドクラス.
 * 分類し難い共通的なメソッドを格納。
 * 増えてきたらメソッドを分けること
 * @author y-suzuki
 *
 */
public class CommonUtils {

  /**
   * NULLなプロパティ名を取得する
   * @param source
   * @return
   */
  public static String[] getNullPropertyNames(Object source) {
    final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
    return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
        .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
        .toArray(String[]::new);
  }
}
