
## 实现功能
1. 自动生成dto,dao,xml,service,controller
2. 可设置生成的dto继承基类，支持lombok


## 插件用法

1. 在该项目执行以下命令，把jar包上传到本地仓库
mvn clean package -Dmaven.test.skip=true
mvn install 

2. 把该项目/resources/generatorConfig.xml复制到要生成代码项目的recourses目录下
3. 根据自己需要，修改generatorConfig.xml
4. pom.xml加入以下设置
```xml
<dependencies>
       <dependency>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-core</artifactId>
                <version>1.3.7</version>
            </dependency>
</dependencies>

 <profiles>
        <profile>
            <id>mybatis</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.mybatis.generator</groupId>
                        <artifactId>mybatis-generator-maven-plugin</artifactId>
                        <version>1.3.7</version>
                        <configuration>
                            <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
                            <verbose>true</verbose>
                            <overwrite>true</overwrite>
                        </configuration>
                        <executions>
                            <execution>
                                <id>Generate MyBatis Artifacts</id>
                                <goals>
                                    <goal>generate</goal>
                                </goals>
                            </execution>
                        </executions>
                        <dependencies>
                            <dependency>
                                <groupId>org.mybatis.generator</groupId>
                                <artifactId>mybatis-generator-core</artifactId>
                                <version>1.3.7</version>
                            </dependency>

                            <dependency>
                                <groupId>mysql</groupId>
                                <artifactId>mysql-connector-java</artifactId>
                                <version>5.1.47</version>
                            </dependency>

                            <dependency>
                                <groupId>com.zheng</groupId>
                                <artifactId>mybatis-generator-lombok-plugin</artifactId>
                                <version>1.0-SNAPSHOT</version>
                            </dependency>

                        </dependencies>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
```


