<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">

<img src="Installer/icon.png" width="30%" style="position: relative; top: 0; right: 0;" alt="Project Logo"/>

# VICTUSHUB

<em>Empowering Control. Elevating Performance.</em>

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

Introducing VictusHub, a comprehensive tool for fan control, keyboard color and backlight management, and EC fan monitoring.

**Why VictusHub?**

This project empowers developers to streamline system management and optimize performance. The core features include:

- 🔋 **Fan Control:** Easily manage fan speeds .
- 🎨 **Keyboard Color/Backlight Management:** Customize keyboard backlighting and color settings for optimal performance.
- 💻 **EC Fan Monitoring:** Monitor EC fans in real-time, ensuring optimal system performance.

---

## Features

|      | Component       | Details                              |
| :--- | :-------------- | :----------------------------------- |
| ⚙️  | **Architecture**  | <ul><li>Uses Gradle as its build tool</li><li>Written in Kotlin and Java</li></ul> |
| 🔩 | **Code Quality**  | <ul><li>Uses controlsfx, dlsc, formsfx, ikonli, junit, jupiter, kordamp, org libraries</li><li>Has a settings.gradle file for Gradle settings</li></ul> |
| 📄 | **Documentation** | <ul><li>No documentation provided in the codebase</li></ul> |
| 🔌 | **Integrations**  | <ul><li>Uses GitHub Actions for CI/CD</li><li>Has a build.yml file for GitHub Actions workflow</li></ul> |
| 🧩 | **Modularity**    | <ul><li>Separates GUI and service components in different modules (VictusHub-gui and VictusService)</li></ul> |


---

## Project Structure

```sh
└── VictusHub/
    ├── .github
    │   └── workflows
    ├── Installer
    │   ├── icon.png
    │   ├── setup.sh
    │   └── uninstaller.sh
    ├── VictusService
    │   ├── .gitignore
    │   ├── .idea
    │   ├── build.gradle
    │   ├── gradle
    │   ├── gradlew
    │   ├── gradlew.bat
    │   ├── settings.gradle
    │   └── src
    ├── Victushub-gui
    │   ├── .gitignore
    │   ├── .idea
    │   ├── Installer
    │   ├── LICENSE
    │   ├── build.gradle.kts
    │   ├── gradle
    │   ├── gradlew
    │   ├── gradlew.bat
    │   ├── images
    │   ├── qodana.yaml
    │   ├── settings.gradle.kts
    │   └── src
    ├── build
    │   └── reports
    ├── build.gradle.kts
    ├── gradle
    │   └── wrapper
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle
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
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/settings.gradle'>settings.gradle</a></b></td>
					<td style='padding: 8px;'>- VictusHub is a comprehensive tool that enables fan control, keyboard color and backlight management, and ec fan monitoring<br>- The provided settings.gradle file serves as the foundation of this project, integrating Victushub-gui and VictusService modules to create a seamless user experience<br>- By leveraging these components, users can efficiently manage their systems fans, lighting, and cooling systems.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control and this app for fan control and keyboard color and backlight control tool and have service for checking ec fans</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Assembles the Victus project by copying native builds from Victushub-gui and VictusService into an Installer directory<br>- This task depends on the successful compilation of both projects, ensuring a complete and functional installation package is generated.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- Victushub-gui Submodule -->
	<details>
		<summary><b>Victushub-gui</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ Victushub-gui</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/settings.gradle.kts'>settings.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Configures the VictusHub-gui project by defining its name and plugin management settings<br>- This file establishes the foundation for the projects structure and dependencies, enabling the development of a GUI-based application for fan control, keyboard color and backlight control, and ec fans monitoring.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/qodana.yaml'>qodana.yaml</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/build.gradle.kts'>build.gradle.kts</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-controlThe Victushub-gui codebase provides a comprehensive fan control and keyboard color and backlight control tool, offering services for checking EC fans.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/LICENSE'>LICENSE</a></b></td>
					<td style='padding: 8px;'>- Empowers users to control fan speed, keyboard color, and backlight settings with ease<br>- This GUI application provides a user-friendly interface to manage system fans, adjust keyboard illumination, and monitor system performance<br>- With its intuitive design, users can effortlessly customize their computing experience.</td>
				</tr>
			</table>
			<!-- Installer Submodule -->
			<details>
				<summary><b>Installer</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ Victushub-gui.Installer</b></code>
					<table style='width: 100%; border-collapse: collapse;'>
					<thead>
						<tr style='background-color: #f8f9fa;'>
							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
							<th style='text-align: left; padding: 8px;'>Summary</th>
						</tr>
					</thead>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/Installer/uninstaller.sh'>uninstaller.sh</a></b></td>
							<td style='padding: 8px;'>- Uninstalling VictusHub restores the applications original state by moving its binary back to a safe location, removing sudoers fragments, desktop entries, and icons, and refreshing the desktop cache if necessary<br>- This script provides a comprehensive solution for fully uninstalling and restoring VictusHub<br>- Special thanks to Vilez0 for the GUI inspiration.</td>
						</tr>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/Installer/setup.sh'>setup.sh</a></b></td>
							<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control Summary:Installs and sets up VictusHub, a fan control and keyboard color and backlight control tool with service for checking EC fans<br>- The installer moves the binary to /usr/local/bin, sets up passwordless sudo, creates a desktop entry with icon, and updates the desktop database.</td>
						</tr>
					</table>
				</blockquote>
			</details>
			<!-- src Submodule -->
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ Victushub-gui.src</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ Victushub-gui.src.main</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ Victushub-gui.src.main.java</b></code>
									<table style='width: 100%; border-collapse: collapse;'>
									<thead>
										<tr style='background-color: #f8f9fa;'>
											<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
											<th style='text-align: left; padding: 8px;'>Summary</th>
										</tr>
									</thead>
										<tr style='border-bottom: 1px solid #eee;'>
											<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/java/module-info.java'>module-info.java</a></b></td>
											<td style='padding: 8px;'>- Victushub-gui module-info.java defines the architecture of Victushub-gui, a comprehensive tool for fan control and keyboard color/backlight management<br>- It enables seamless integration with JavaFX, controlsfx, formsfx, ikonli-javafx, logging, and slf4j libraries<br>- This configuration allows for efficient communication between modules, ensuring a robust and scalable application.</td>
										</tr>
									</table>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ Victushub-gui.src.main.java.com</b></code>
											<!-- range Submodule -->
											<details>
												<summary><b>range</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ Victushub-gui.src.main.java.com.range</b></code>
													<!-- victusHub Submodule -->
													<details>
														<summary><b>victusHub</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ Victushub-gui.src.main.java.com.range.victusHub</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/java/com/range/victusHub/VictusHub.java'>VictusHub.java</a></b></td>
																	<td style='padding: 8px;'>- Launches the Victus Hub graphical user interface (GUI) application, providing a centralized hub for controlling and monitoring various system components<br>- The GUI enables users to manage fan speeds, keyboard backlighting, and other features, offering a convenient and intuitive way to customize their computing experience.</td>
																</tr>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/java/com/range/victusHub/Launcher.java'>Launcher.java</a></b></td>
																	<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
																</tr>
															</table>
															<!-- fan Submodule -->
															<details>
																<summary><b>fan</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ Victushub-gui.src.main.java.com.range.victusHub.fan</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/java/com/range/victusHub/fan/FanCounter.java'>FanCounter.java</a></b></td>
																			<td style='padding: 8px;'>- Detects the number of fans connected to an HP laptop.This file provides a simple way to count the number of fans installed on an HP laptop by scanning the systems hardware monitoring directory and counting the number of fan input files found<br>- The result is returned as an integer value, allowing for easy integration into larger applications or scripts.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/java/com/range/victusHub/fan/FanAndKeyboardController.java'>FanAndKeyboardController.java</a></b></td>
																			<td style='padding: 8px;'>- Control fan speeds and keyboard backlight on HP laptops using this GUI application<br>- The app detects available fans, displays their current RPM values, and allows users to adjust fan speeds<br>- Additionally, it controls the keyboard backlights brightness and color<br>- The application stores its settings in a configuration file for persistence.Special thanks to Vilez0 for the GUI inspiration<br>- His original app can be found here: https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
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
							<!-- resources Submodule -->
							<details>
								<summary><b>resources</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ Victushub-gui.src.main.resources</b></code>
									<!-- com.range.victusHub Submodule -->
									<details>
										<summary><b>com.range.victusHub</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ Victushub-gui.src.main.resources.com.range.victusHub</b></code>
											<table style='width: 100%; border-collapse: collapse;'>
											<thead>
												<tr style='background-color: #f8f9fa;'>
													<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
													<th style='text-align: left; padding: 8px;'>Summary</th>
												</tr>
											</thead>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/resources/com.range.victusHub/style.css'>style.css</a></b></td>
													<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-controlSummary:Configure and control fan speeds, keyboard color, and backlight settings with this intuitive graphical user interface (GUI) tool.</td>
												</tr>
												<tr style='border-bottom: 1px solid #eee;'>
													<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Victushub-gui/src/main/resources/com.range.victusHub/hello-view.fxml'>hello-view.fxml</a></b></td>
													<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control Summary:Configure and control fan speed, keyboard backlight, and color using this intuitive graphical user interface (GUI)<br>- The Victus Hub application provides a centralized platform to manage system settings, offering real-time status updates and customizable controls for optimal performance.</td>
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
	<!-- VictusService Submodule -->
	<details>
		<summary><b>VictusService</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ VictusService</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/VictusService/settings.gradle'>settings.gradle</a></b></td>
					<td style='padding: 8px;'>- Control fan speed and keyboard color/backlight settings with ease using this VictusService application<br>- This tool provides a convenient interface to manage fans and lighting on compatible devices, streamlining the process of monitoring and adjusting system components<br>- With its intuitive design, users can quickly access and customize their devices performance and visual settings.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/VictusService/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>Https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/VictusService/build.gradle'>build.gradle</a></b></td>
					<td style='padding: 8px;'>- Provides a comprehensive fan control and keyboard color/backlight management tool, offering real-time monitoring of EC fans<br>- The service enables users to adjust fan speeds and customize keyboard lighting settings, streamlining system performance optimization and enhancing overall user experience.</td>
				</tr>
			</table>
			<!-- src Submodule -->
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ VictusService.src</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ VictusService.src.main</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ VictusService.src.main.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ VictusService.src.main.java.com</b></code>
											<!-- range Submodule -->
											<details>
												<summary><b>range</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ VictusService.src.main.java.com.range</b></code>
													<table style='width: 100%; border-collapse: collapse;'>
													<thead>
														<tr style='background-color: #f8f9fa;'>
															<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
															<th style='text-align: left; padding: 8px;'>Summary</th>
														</tr>
													</thead>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/VictusService/src/main/java/com/range/Main.java'>Main.java</a></b></td>
															<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-controlSummary:Configures and controls HP laptop fans, keyboard backlight, and color using a configuration file<br>- The program reads settings from the file, adjusts fan speeds, sets keyboard light intensity, and changes color based on user-defined values.</td>
														</tr>
														<tr style='border-bottom: 1px solid #eee;'>
															<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/VictusService/src/main/java/com/range/CommandRunner.java'>CommandRunner.java</a></b></td>
															<td style='padding: 8px;'>- Enables asynchronous command execution, allowing users to run shell commands without blocking the main thread<br>- This feature is particularly useful for controlling system fans and backlights, providing a convenient way to manage system settings.</td>
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
					<td style='padding: 8px;'>- Restores and uninstalls VictusHub by moving GUI and Service binaries back to their original location, cleaning up sudoers and desktop entries, and removing icons<br>- This script ensures a seamless uninstallation process, returning the applications files to their original directory while also refreshing the desktop cache for optimal performance.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/Installer/setup.sh'>setup.sh</a></b></td>
					<td style='padding: 8px;'>- Installs and configures VictusHub, a GUI application and service, on various Linux init systems<br>- The installer moves binaries, sets up passwordless sudo, creates a desktop entry, and installs the service under systemd, openrc, sysvinit, runit, or dinit.Special thanks to Vilez0 for the GUI inspiration<br>- His original app can be found here: https://github.com/Vilez0/hp-wmi-fan-and-backlight-control</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- .github Submodule -->
	<details>
		<summary><b>.github</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ .github</b></code>
			<!-- workflows Submodule -->
			<details>
				<summary><b>workflows</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ .github.workflows</b></code>
					<table style='width: 100%; border-collapse: collapse;'>
					<thead>
						<tr style='background-color: #f8f9fa;'>
							<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
							<th style='text-align: left; padding: 8px;'>Summary</th>
						</tr>
					</thead>
						<tr style='border-bottom: 1px solid #eee;'>
							<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/.github/workflows/build.yml'>build.yml</a></b></td>
							<td style='padding: 8px;'>- Https://github.com/Vilez0/hp-wmi-fan-and-backlight-controlSummary:Automates the build and release process of VictusHub, a fan control and keyboard color and backlight control tool with ec fans service<br>- The workflow builds the jar file using Gradle, installs native dependencies, and creates a zip installer folder<br>- It also releases the asset to GitHub with a custom name and description.</td>
						</tr>
					</table>
				</blockquote>
			</details>
		</blockquote>
	</details>
	<!-- build Submodule -->
	<details>
		<summary><b>build</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ build</b></code>
			<!-- reports Submodule -->
			<details>
				<summary><b>reports</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ build.reports</b></code>
					<!-- problems Submodule -->
					<details>
						<summary><b>problems</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ build.reports.problems</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/range79/VictusHub/blob/master/build/reports/problems/problems-report.html'>problems-report.html</a></b></td>
									<td style='padding: 8px;'>- Summary:<strong> This code provides a GUI-based tool for controlling fans and keyboard backlighting, as well as checking fan speeds<br>- It offers a user-friendly interface to manage these features, making it easy to adjust settings and monitor performance.</strong>Additional Context:<em>*</em> The project structure is not provided in this context.<em> The file path is <code>build/reports/problems/problems-report.html</code>.</em> The file content appears to be an HTML report, but its relevance to the code file is unclear.</td>
								</tr>
							</table>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---

## Getting Started

### Prerequisites

This project requires the following dependencies:

- **Programming Language:** Java
- **Package Manager:** Gradle

### Installation

Build VictusHub from the source and intsall dependencies:

1. **Clone the repository:**

    ```sh
    ❯ git clone https://github.com/range79/VictusHub/
    ```

2. **Navigate to the project directory:**

    ```sh
    ❯ cd VictusHub
    ```

3. **Install the dependencies:**



	```sh
	❯ gradle victusBuild
	```

### Usage

Run the project with:

**Using [gradle](https://gradle.org/):**
```sh
gradle run
```

### Testing

Victushub uses the {__test_framework__} test framework. Run the test suite with:

**Using [gradle](https://gradle.org/):**
```sh
gradle test
```

---

## Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

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
   git clone https://github.com/range79/VictusHub/
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
