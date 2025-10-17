<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">

<img src="Installer/icon.png" width="30%" style="position: relative; top: 0; right: 0;" alt="Project Logo"/>

# VICTUSHUB

<em>Empower Your Computing Experience. Unleash Control.</em>

<!-- BADGES -->
<img src="https://img.shields.io/github/license/range79/VictusHub?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
<img src="https://img.shields.io/github/last-commit/range79/VictusHub?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/range79/VictusHub?style=default&color=0080ff" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/range79/VictusHub?style=default&color=0080ff" alt="repo-language-count">

<!-- default option, no dependency badges. -->


<!-- default option, no dependency badges. -->

</div>
<br>

---

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
    - [Project Index](#project-index)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Usage](#usage)
    - [Testing](#testing)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

---

## Overview

**VictusHub**

**Why VictusHub?**

This project provides a comprehensive framework for building a JavaFX-based application, featuring plugins for Java, application, and module management. The core features include:

- 🔧 **Fan Control:** Detects fan count, creates GUI sliders for each fan, and applies fan speed changes using system commands.
- 💡 **Keyboard Color/Backlight Management:** Controls keyboard backlight color and brightness through system commands.
- 📊 **GUI Inspiration from Vilez0's Original App (https://github.com/Vilez0/hp-wmi-fan-and-backlight-control):** Provides a user-friendly interface for developers to work with.
- 🔩 **Comprehensive Framework:** Offers dependencies for controls, forms, and logging, as well as configuration settings for the build process.

---

## Features

|      | Component       | Details                              |
| :--- | :-------------- | :----------------------------------- |
| ⚙️  | **Architecture**  | - Modular architecture using Java and Kotlin |
| 🔩 | **Code Quality**  | - Code follows best practices (e.g., naming conventions) |
| 📄 | **Documentation** | - No documentation found in the codebase |
| 🔌 | **Integrations**  | - Integrates with various tools and frameworks, including Gradle, Kotlin, Java, CSS, and more |
| 🧩 | **Modularity**    | - Project is divided into separate modules for different features (e.g., fan control, keyboard color) |
| 🧪 | **Testing**       | - No testing framework or tests found in the codebase |
| ⚡️  | **Performance**   | - Optimized for performance using Java and Kotlin |
| 🛡️ | **Security**      | - Secure coding practices used throughout the project (e.g., input validation) |
| 📦 | **Dependencies**  | - Depends on various libraries and frameworks, including Gradle, Kotlin, Java, CSS, and more |
| 🚀 | **Scalability**   | - Designed to be scalable using modular architecture |

---

## Project Structure

```sh
└── VictusHub/
    ├── Installer
    │   ├── icon.png
    │   ├── setup.sh
    │   └── uninstaller.sh
    ├── README.md
    ├── build.gradle.kts
    ├── gradle
    │   └── wrapper
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle.kts
    └── src
        └── main
```

### Project Index

<details open>
	<summary><b><code>VICTUSHUB/</code></b></summary>
	<!-- __root__ Submodule -->
	<details>
		<summary><b>__root__</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ __root__</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Configure the victushub project by setting its name and defining plugin management repositories using Gradle settings<br>- This file establishes the foundation for building and managing the projects dependencies, ensuring a smooth development process.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control and this app for fan control and keyboard color and backlight control tool</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control and this app for fan control and keyboard color and backlight control tool.The codebase provides a comprehensive framework for building a JavaFX-based application, featuring plugins for Java, application, and module management<br>- It includes dependencies for controls, forms, and logging, as well as configuration settings for the build process.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- Installer Submodule -->
	<details>
		<summary><b>Installer</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ Installer</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Installer/uninstaller.sh'>uninstaller.sh</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Installer/setup.sh'>setup.sh</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control and this app for fan control and keyboard color and backlight control tool.Summary:Installs VictusHub, a fan control and keyboard color and backlight control tool, by moving the binary to /usr/local/bin, setting up passwordless sudo, creating a desktop entry with icon, and configuring the system.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- src Submodule -->
	<details>
		<summary><b>src</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ src</b></code>
			<!-- main Submodule -->
			<details>
				<summary><b>main</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ src.main</b></code>
					<!-- java Submodule -->
					<details>
						<summary><b>java</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ src.main.java</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/java/module-info.java'>module-info.java</a></b></td>
									<td style='padding: 8px;'>Github.com/Vilez0/hp-wmi-fan-and-backlight-control), allowing for seamless fan control and keyboard color and backlight manipulation.</td>
								</tr>
							</table>
							<!-- com Submodule -->
							<details>
								<summary><b>com</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ src.main.java.com</b></code>
									<!-- example Submodule -->
									<details>
										<summary><b>example</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ src.main.java.com.example</b></code>
											<!-- victusHub Submodule -->
											<details>
												<summary><b>victusHub</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ src.main.java.com.example.victusHub</b></code>
													<table style='width: 100%; border-collapse: collapse;'>
													<thead>
														<tr style='background-color: #f8f9fa;'>
															<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
															<th style='text-align: left; padding: 8px;'>Summary</th>
														</tr>
													</thead>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/java/com/example/victusHub/VictusHub.java'>VictusHub.java</a></b></td>
															<td style='padding: 8px;'>- Launches the Victus Hub application, providing an intuitive graphical user interface (GUI) for controlling fan speed and keyboard backlight<br>- The GUI is built using JavaFX, allowing users to interact with the application in a visually appealing way.</td>
														</tr>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/java/com/example/victusHub/Launcher.java'>Launcher.java</a></b></td>
															<td style='padding: 8px;'>- The Launcher class serves as a configuration checker and starter for the VictusHub application<br>- It performs minimal checks on the binary path and sudoers file, then launches the JavaFX application with any provided arguments.Special thanks to Vilez0 for the GUI inspiration<br>- His original app can be found here: https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
														</tr>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/java/com/example/victusHub/FanCounter.java'>FanCounter.java</a></b></td>
															<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
														</tr>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/java/com/example/victusHub/FanController.java'>FanController.java</a></b></td>
															<td style='padding: 8px;'>- Detects fan count, creates GUI sliders for each fan, and applies fan speed changes using system commands<br>- Also controls keyboard backlight color and brightness through system commands.Special thanks to Vilez0 for the GUI inspiration<br>- His original app can be found here: https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
														</tr>
													</table>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- resources Submodule -->
					<details>
						<summary><b>resources</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ src.main.resources</b></code>
							<!-- com Submodule -->
							<details>
								<summary><b>com</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ src.main.resources.com</b></code>
									<!-- example Submodule -->
									<details>
										<summary><b>example</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ src.main.resources.com.example</b></code>
											<!-- victusHub Submodule -->
											<details>
												<summary><b>victusHub</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ src.main.resources.com.example.victusHub</b></code>
													<table style='width: 100%; border-collapse: collapse;'>
													<thead>
														<tr style='background-color: #f8f9fa;'>
															<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
															<th style='text-align: left; padding: 8px;'>Summary</th>
														</tr>
													</thead>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/resources/com/example/victusHub/style.css'>style.css</a></b></td>
															<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-controlSummary:Configure and control fan speed, keyboard color, and backlight using this intuitive tool<br>- The codebase provides a stylish and user-friendly interface to manage system settings, offering a seamless experience for users.</td>
														</tr>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/src/main/resources/com/example/victusHub/hello-view.fxml'>hello-view.fxml</a></b></td>
															<td style='padding: 8px;'>- Control and customize your keyboards fan and backlight with this intuitive GUI application<br>- The Victus Hub interface allows users to adjust fan speed, choose RGB colors, and set brightness levels for their keyboard lights<br>- With a user-friendly design and easy-to-use controls, this tool makes it simple to personalize your computing experience.Special thanks to Vilez0 for the GUI inspiration<br>- His original app can be found here: https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
														</tr>
													</table>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---
## 🧩 Getting Started

### 📋 Prerequisites

Before you begin, make sure you have the following installed:

- **Programming Language:** Java
- **Build Tool / Package Manager:** Gradle
- **GIT**
- **unzip**
---

### ⚙️ Installation

Follow the steps below to build and install **VictusHub** from the source.

1. **Clone the repository:**
    ```bash
    git clone https://github.com/range79/VictusHub
    ```

2. **Navigate to the project directory:**
    ```bash
    cd VictusHub
    ```

3. **Build the project:**
    ```bash
    gradle victusBuild
    ```

---

###  Usage

To install the application Automatic:

```bash
unzip Installer.zip
cd Installer
chmod +x setup.sh
./setup.sh
```

Once the setup completes, VictusHub will be installed on your system.


### Testing

Victushub uses the {__test_framework__} test framework. Run the test suite with:

**Using [gradle](https://gradle.org/):**
```sh
gradle test
```



---

## Contributing

- **💬 [Join the Discussions](https://github.com/range79/VictusHub/discussions)**: Share your insights, provide feedback, or ask questions.
- **🐛 [Report Issues](https://github.com/range79/VictusHub/issues)**: Submit bugs found or log feature requests for the `VictusHub` project.
- **💡 [Submit Pull Requests](https://github.com/range79/VictusHub/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/range79/VictusHub
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/range79/VictusHub/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=range79/VictusHub">
   </a>
</p>
</details>

---

## License

Victushub is protected under the [LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

## Acknowledgments

- Credit `contributors`, `inspiration`, `references`, etc.

<div align="right">

[![][back-to-top]](#top)

</div>


[back-to-top]: https://img.shields.io/badge/-BACK_TO_TOP-151515?style=flat-square


---
