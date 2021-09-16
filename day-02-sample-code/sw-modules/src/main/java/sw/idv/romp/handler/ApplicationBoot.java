package sw.idv.romp.handler;

import sw.idv.romp.annotations.Prejump;
import sw.idv.romp.proxy.ObjectCloneHandler;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class ApplicationBoot {


    private static volatile ApplicationBoot instance = null;

    public static synchronized ApplicationBoot getInstance() {
        if (instance == null) {
            instance = new ApplicationBoot();
        }
        return instance;
    }

    public <T> void run(Class<T> clazz) {
        String packageName = clazz.getPackage().getName();

        try {
            String[] classes1 = instance.getClasses(packageName);
            filterAnnotations(classes1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void filterAnnotations(String[] classes) {
        Arrays.stream(classes).forEach( clazz -> {
            try {
                Object object = Class.forName(clazz).newInstance();
                Arrays.stream(object.getClass().getDeclaredFields()).forEach(fieldArgs -> {
                    if ( fieldArgs.isAnnotationPresent(Prejump.class)) {
                        Prejump prejump1 = fieldArgs.getAnnotation(Prejump.class);
                        String[] packetageNameArray = fieldArgs.getType().toString().split("\\.");
                            try {
                                Object obj = null;
                                switch (packetageNameArray[packetageNameArray.length-1]) {
                                    case "String":
                                        obj = new String(prejump1.value());
                                        break;
                                    case "Integer":
                                        obj = new Integer(prejump1.value());
                                        break;
                                    case "Double":
                                        obj = new Double(prejump1.value());
                                        break;
                                    case "Long":
                                        obj = new Long(prejump1.value());
                                        break;
                                    case "float":
                                        obj = new Float(prejump1.value());
                                        break;
                                    case "int":
                                        obj = new Integer(prejump1.value());
                                        break;
                                    case "double":
                                        obj = new Double(prejump1.value());
                                        break;
                                    default:
                                        try {
                                            obj = Class.forName(prejump1.value()).newInstance();
                                        } catch (InstantiationException instantiationException) {
                                         //   System.out.println("No such >>> InstantiationException");
                                        } catch (ClassNotFoundException classNotFoundException) {
                                            System.out.println("No such >>> ClassNotFoundException");
                                        }
                                        break;
                                }
                                Field field = object.getClass().getDeclaredField(fieldArgs.getName().toString());
                                field.setAccessible(true);
                                field.set(object, obj);
                            } catch (IllegalAccessException | NoSuchFieldException e) {
                                System.out.println("No such >>> NoSuchFieldException");
                            }

                    }
                });
                Arrays.stream(object.getClass().getMethods()).forEach(method -> {
                    Method method1 = null;
                    if (method.isAnnotationPresent(Prejump.class)) {
                        try {
                            method1 = object.getClass().getMethod(method.getName());
                        } catch (NoSuchMethodException noSuchMethodException) {
                            System.out.println("Core :: error :: NoSuchFieldException ! ");
                        }

                        if (method.isAnnotationPresent(Prejump.class)) {

                        } else {
                            System.out.println("沒有設定 @Prejump 標註");
                        }
                    }
                });
                ObjectCloneHandler.getInstance().getInvocationHandler().put(clazz,object);
            } catch (IllegalAccessException illegalAccessException) {
                System.out.println("Core :: error :: IllegalAccessException ! ");
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("Core :: error :: classNotFoundException ! ");
            } catch (InstantiationException instantiationException) {
              //  System.out.println("Core :: error :: InstantiationException ! ");
            }

        });

    }

    private String[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<String> classes = new ArrayList<String>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new String[classes.size()]);
    }

    private List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<String> classes = new ArrayList<String>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
            }
        }
        return classes;
    }


}
