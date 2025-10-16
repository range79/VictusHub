
plugins {
    java
    application
    id("org.javamodularity.moduleplugin") version "1.8.15"
    id("org.openjfx.javafxplugin") version "0.0.13"
    id ("com.gluonhq.gluonfx-gradle-plugin") version  "1.0.27"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val junitVersion = "5.12.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

application {
    mainModule.set("com.example.victusHub")
    mainClass.set("com.example.victusHub.Launcher")
}

javafx {
    version = "17.0.14"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("org.controlsfx:controlsfx:11.2.1")
    implementation("com.dlsc.formsfx:formsfx-core:11.6.0") {
        exclude(group = "org.openjfx")
    }
    implementation("org.kordamp.ikonli:ikonli-javafx:12.3.1")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.17")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

gluonfx {
    reflectionList = listOf(
        "com.example.victusHub.VictusHub",
        "com.example.victusHub.FanController",


        "javafx.scene.control.Button",
        "javafx.scene.control.Label",
        "javafx.scene.control.TextField",
        "javafx.scene.control.PasswordField",
        "javafx.scene.control.TextArea",
        "javafx.scene.control.CheckBox",
        "javafx.scene.control.RadioButton",
        "javafx.scene.control.ToggleGroup",
        "javafx.scene.control.ComboBox",
        "javafx.scene.control.ListView",
        "javafx.scene.control.TableView",
        "javafx.scene.control.TableColumn",
        "javafx.scene.control.Slider",
        "javafx.scene.control.ColorPicker",
        "javafx.scene.control.TitledPane",
        "javafx.scene.control.TabPane",
        "javafx.scene.control.Tab",
        "javafx.scene.control.MenuBar",
        "javafx.scene.control.Menu",
        "javafx.scene.control.MenuItem",
        "javafx.scene.layout.AnchorPane",
        "javafx.scene.layout.GridPane",
        "javafx.scene.layout.VBox",
        "javafx.scene.layout.HBox",
        "javafx.scene.layout.StackPane"
    )
    resourcesList = listOf("src/main/resources/com/example/victusHub/hello-view.fxml")
}

