package snippets.jdk.introspection.a1;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanIntrospector {
    public BeanIntrospector() {
        try {
            MyBean beanObj = new MyBean();
            BeanInfo bInfoObject = Introspector.getBeanInfo(beanObj.getClass(), beanObj.getClass().getSuperclass());
            String output = "";

            output = "methods：\n";
            MethodDescriptor[] mDescArray = bInfoObject.getMethodDescriptors();
            for (int i = 0; i < mDescArray.length; i++) {
                String methodName = mDescArray[i].getName();
                String methodParams = new String();
                Method methodObj = mDescArray[i].getMethod();
                Class[] parameters = methodObj.getParameterTypes();
                if (parameters.length > 0) {
                    methodParams = parameters[0].getName();
                    for (int j = 1; j < parameters.length; j++) {
                        methodParams = methodParams + "," + parameters[j].getName();
                    }
                }
                output += methodName + "(" + methodParams + ")\n";
            }
            System.out.println(output);

            
            output = "properties：\n";
            PropertyDescriptor[] mPropertyArray = bInfoObject.getPropertyDescriptors();
            for (int i = 0; i < mPropertyArray.length; i++) {
                String propertyName = mPropertyArray[i].getName();
                Class propertyType = mPropertyArray[i].getPropertyType();
                output += propertyName + " ( " + propertyType.getName() + " )\n";
            }
            System.out.println(output);


            output = "events：\n";
            EventSetDescriptor[] mEventArray = bInfoObject.getEventSetDescriptors();
            for (int i = 0; i < mEventArray.length; i++) {
                String EventName = mEventArray[i].getName();
                Class listenerType = mEventArray[i].getListenerType();
                output += EventName + "(" + listenerType.getName() + ")\n";
            }
            System.out.println(output);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BeanIntrospector();
    }
}