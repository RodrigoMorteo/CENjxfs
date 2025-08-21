# Contributing to CENjxfs

First off, thank you for considering contributing to the CENjxfs project! We welcome and encourage contributions from the community. Your help is essential for building a complete and robust J/XFS implementation.

This document provides guidelines for contributing to the project. Please read it carefully to ensure a smooth and effective collaboration process.

## Table of Contents
- [Code of Conduct](#code-of-conduct)
- [How to Contribute](#how-to-contribute)
  - [Reporting Bugs](#reporting-bugs)
  - [Suggesting Enhancements](#suggesting-enhancements)
  - [Your First Code Contribution](#your-first-code-contribution)
- [Development Process](#development-process)
  - [Branching Strategy](#branching-strategy)
  - [Pull Request (PR) Process](#pull-request-pr-process)
- [Coding Standards](#coding-standards)
  - [Code Style](#code-style)
  - [Java Version](#java-version)
  - [Javadoc](#javadoc)
  - [Testing](#testing)
- [License](#license)

## Code of Conduct

This project and everyone participating in it is governed by our [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior.

## How to Contribute

### Reporting Bugs

If you find a bug, please ensure the bug has not already been reported by searching on GitHub under [Issues](https://github.com/RodrigoMorteo/CENjxfs/issues). If you're unable to find an open issue addressing the problem, [open a new one](https://github.com/RodrigoMorteo/CENjxfs/issues/new). Be sure to include a **title and clear description**, as much relevant information as possible, and a **code sample or an executable test case** demonstrating the expected behavior that is not occurring.

### Suggesting Enhancements

If you have an idea for an enhancement, please open an issue to discuss it. This allows us to coordinate efforts and ensure the proposed change aligns with the project's goals as outlined in the [Development Roadmap](plan.md).

### Your First Code Contribution

Unsure where to begin? You can start by looking through `good first issue` and `help wanted` issues:
*   **Good first issues** - These are issues that are well-defined and suitable for new contributors.
*   **Help wanted issues** - These are issues that we would appreciate community help with.

## Development Process

We follow a process inspired by GitFlow to ensure code quality and maintain a clear history. All development happens on feature branches and is merged into the `develop` branch.

### Branching Strategy

1.  **Fork** the repository on GitHub.
2.  **Clone** your fork locally: `git clone https://github.com/your-username/CENjxfs.git`
3.  **Create a branch** from the `develop` branch. Please use a descriptive branch name, like `feature/implement-jxfs-logger` or `fix/pinpad-event-bug`.
    ```sh
    git checkout develop
    git pull origin develop
    git checkout -b feature/your-feature-name
    ```

### Pull Request (PR) Process

1.  **Commit your changes.** Write clear, concise commit messages.
2.  **Push your branch** to your fork on GitHub.
3.  **Open a Pull Request** against the `develop` branch of the `RodrigoMorteo/CENjxfs` repository.
4.  In your PR description, please:
    *   Provide a clear explanation of the changes.
    *   Link to the GitHub Issue it resolves (e.g., `Closes #123`).
    *   Describe how your changes have been tested.
5.  The project maintainer will review your PR. Be prepared to discuss your changes and make adjustments if necessary.

## Coding Standards

### Code Style

While we don't enforce a strict style guide automatically yet, please adhere to the following principles:
*   Follow standard Java naming conventions.
*   Use consistent indentation (4 spaces).
*   Keep lines under 120 characters.
*   Write clear, self-documenting code where possible.

### Java Version

The project targets **Java 8**. Please ensure your code is compatible.

### Javadoc

Comprehensive Javadoc is required for a library like this.
*   All `public` and `protected` classes, methods, and fields **must** have Javadoc.
*   Explain what the code does, its parameters, and what it returns.
*   Document any thrown exceptions (`@throws`).

### Testing

**Testing is mandatory.** A hardware abstraction layer must be rigorously tested to be reliable.
*   Every new feature **must** be accompanied by a corresponding suite of unit tests.
*   Bug fixes **should** include a new test that fails without the fix and passes with it.
*   We use **JUnit 5** for testing.
*   Place your tests in the `src/test/java` directory, following the same package structure as the source code.

## License

By contributing to CENjxfs, you agree that your contributions will be licensed under its MIT License.