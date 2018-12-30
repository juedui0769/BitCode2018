package com.wxg.javaenv;

import java.util.Map;

/**
 *
 *
 -- listing properties --
 java.runtime.name=Java(TM) SE Runtime Environment
 sun.boot.library.path=E:\Program Files\Java\jdk1.8.0_181\jr...
 java.vm.version=25.181-b13
 java.vm.vendor=Oracle Corporation
 java.vendor.url=http://java.oracle.com/
 path.separator=;
 java.vm.name=Java HotSpot(TM) 64-Bit Server VM
 file.encoding.pkg=sun.io
 user.script=
 user.country=CN
 sun.java.launcher=SUN_STANDARD
 sun.os.patch.level=Service Pack 1
 java.vm.specification.name=Java Virtual Machine Specification
 user.dir=F:\wxg111_openapi\BitCode2018-parent
 java.runtime.version=1.8.0_181-b13
 java.awt.graphicsenv=sun.awt.Win32GraphicsEnvironment
 java.endorsed.dirs=E:\Program Files\Java\jdk1.8.0_181\jr...
 os.arch=amd64
 java.io.tmpdir=C:\Users\Wxg\AppData\Local\Temp\
 line.separator=

 java.vm.specification.vendor=Oracle Corporation
 user.variant=
 os.name=Windows 7
 sun.jnu.encoding=GBK
 java.library.path=E:\Program Files\Java\jdk1.8.0_181\bi...
 java.specification.name=Java Platform API Specification
 java.class.version=52.0
 sun.management.compiler=HotSpot 64-Bit Tiered Compilers
 os.version=6.1
 user.home=C:\Users\Wxg
 user.timezone=
 java.awt.printerjob=sun.awt.windows.WPrinterJob
 file.encoding=UTF-8
 java.specification.version=1.8
 user.name=Wxg
 java.class.path=E:\Program Files\Java\jdk1.8.0_181\jr...
 java.vm.specification.version=1.8
 sun.arch.data.model=64
 java.home=E:\Program Files\Java\jdk1.8.0_181\jre
 sun.java.command=com.wxg.javaenv.EnvPrinter
 java.specification.vendor=Oracle Corporation
 user.language=zh
 awt.toolkit=sun.awt.windows.WToolkit
 java.vm.info=mixed mode
 java.version=1.8.0_181
 java.ext.dirs=E:\Program Files\Java\jdk1.8.0_181\jr...
 sun.boot.class.path=E:\Program Files\Java\jdk1.8.0_181\jr...
 java.vendor=Oracle Corporation
 file.separator=\
 java.vendor.url.bug=http://bugreport.sun.com/bugreport/
 sun.cpu.endian=little
 sun.io.unicode.encoding=UnicodeLittle
 sun.desktop=windows
 sun.cpu.isalist=amd64

 =============

 key: PROCESSOR_LEVEL, val: 6
 key: FP_NO_HOST_CHECK, val: NO
 key: SESSIONNAME, val: Console
 key: ALLUSERSPROFILE, val: C:\ProgramData
 key: PROCESSOR_ARCHITECTURE, val: AMD64
 key: PSModulePath, val: C:\Windows\system32\WindowsPowerShell\v1.0\Modules\
 key: SystemDrive, val: C:
 key: ROCKETMQ_HOME, val: F:\Docs\MQ\RocketMQ\rocketmq-all-4.3.1-bin-release
 key: USERNAME, val: Wxg
 key: ProgramFiles(x86), val: C:\Program Files (x86)
 key: PATHEXT, val: .COM;.EXE;.BAT;.CMD;.VBS;.VBE;.JS;.JSE;.WSF;.WSH;.MSC
 key: PYTHON_HOME, val: E:\Python27
 key: ProgramData, val: C:\ProgramData
 key: ProgramW6432, val: C:\Program Files
 key: HOMEPATH, val: \Users\Wxg
 key: SPRING_HOME, val: E:\software\spring-2.0.5.RELEASE
 key: PROCESSOR_IDENTIFIER, val: Intel64 Family 6 Model 60 Stepping 3, GenuineIntel
 key: M2_HOME, val: E:\software\apache-maven-3.3.9
 key: ProgramFiles, val: C:\Program Files
 key: PUBLIC, val: C:\Users\Public
 key: ELASTICSEARCH_HOME, val: F:\SoftWare\elasticsearch-5.6.12__002
 key: windir, val: C:\Windows
 key: =::, val: ::\
 key: ZOOKEEPER_HOME, val: I:\software\zookeeper-3.4.11
 key: LOCALAPPDATA, val: C:\Users\Wxg\AppData\Local
 key: ChocolateyLastPathUpdate, val: 五 二月 23 13:06:32 2018
 key: USERDOMAIN, val: Wxg-PC
 key: LOGONSERVER, val: \\WXG-PC
 key: WORKON_HOME, val: E:\Python_Env
 key: JAVA_HOME, val: E:\Program Files\Java\jdk1.8.0_181
 key: KOTLIN_HOME, val: E:\software\kotlin-compiler-1.2.21\kotlinc
 key: GRADLE_HOME, val: I:\gradle_repos
 key: ANT_HOME, val: F:\SoftWare\apache-ant-1.9.9
 key: GROOVY_HOME, val: E:\software\groovy-2.4.13
 key: APPDATA, val: C:\Users\Wxg\AppData\Roaming
 key: GRADLE_USER_HOME, val: I:\gradle_user_home
 key: ChocolateyInstall, val: C:\ProgramData\chocolatey
 key: VBOX_MSI_INSTALL_PATH, val: E:\Program Files\Oracle\VirtualBox\
 key: CommonProgramFiles, val: C:\Program Files\Common Files
 key: Path, val: E:\software\Ruby24-x64\bin;C:\Windows\system32;...
 key: OS, val: Windows_NT
 key: COMPUTERNAME, val: WXG-PC
 key: PROCESSOR_REVISION, val: 3c03
 key: CommonProgramW6432, val: C:\Program Files\Common Files
 key: ComSpec, val: C:\Windows\system32\cmd.exe
 key: GRAPHVIZ_DOT, val: E:\Program Files (x86)\Graphviz2.38\bin\dot.exe
 key: RUBYOPT, val: -Eutf-8
 key: SystemRoot, val: C:\Windows
 key: TEMP, val: C:\Users\Wxg\AppData\Local\Temp
 key: HOMEDRIVE, val: C:
 key: USERPROFILE, val: C:\Users\Wxg
 key: TMP, val: C:\Users\Wxg\AppData\Local\Temp
 key: CommonProgramFiles(x86), val: C:\Program Files (x86)\Common Files
 key: NUMBER_OF_PROCESSORS, val: 8
 key: DOCKER_TOOLBOX_INSTALL_PATH, val: e:\Program Files\Docker Toolbox
 *
 */
public class EnvPrinter {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println("\n=============\n");
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            System.out.printf("key: %s, val: %s\n", key, envMap.get(key));
        }
    }
}
