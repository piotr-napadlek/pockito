package org.packito.packagescanner;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Deprecated
public class PackitoPackageScanner implements PackageScanner{

    /**
     * @deprecated use PackitoIndependentPackageScanner instead.
     * @param packageName
     * @return
     * @throws IOException
     */
    @Deprecated
    @Override
    public List<Class<?>> findAllClassesInAPackage(String packageName) throws IOException {
        return ClassPath.from(this.getClass().getClassLoader())
                .getTopLevelClassesRecursive(packageName)
                .stream().map(ClassPath.ClassInfo::load)
                .collect(Collectors.toList());
    }
}
