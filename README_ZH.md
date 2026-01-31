# 项目描述

本项目实现了黑白棋桌游，这是一个双人策略游戏，目标是在游戏结束时拥有更多自己颜色的棋子。玩家在棋盘上放置棋子，通过在任何方向（水平、垂直或对角线）包围对手的棋子来捕获它们。

# 黑白棋规则

1. 游戏在 8x8 棋盘上进行。
2. 每位玩家有一种棋子颜色（白色或黑色）。
3. 要放置棋子，您必须至少捕获一个对手的棋子。
4. 通过在直线（水平、垂直或对角线）上用您的两个棋子包围对手的棋子来捕获它们。
5. 所有被捕获的棋子都会翻转为您的颜色。
6. 如果您无法进行任何有效移动，您就跳过回合。
7. 当没有玩家可以移动时游戏结束。
8. 拥有更多己方颜色棋子的玩家获胜。


# 系统要求

- **Java 开发工具包（JDK）** 11 或更高版本
- **ACM Java 库** (`acm.jar`) - **必需** ⚠️

# 安装步骤

### 1. 克隆仓库
```bash
git clone https://github.com/FelistaYE/Othello.git
cd Othello
```

### 2. 下载 ACM Java 库（必需）

从以下来源之一下载 `acm.jar` 文件：

- **直接链接**：https://cs.stanford.edu/people/eroberts/jtf/acm.jar
- **官方网站**：[斯坦福 ACM Java 任务小组](https://cs.stanford.edu/people/eroberts/jtf/)

将 acm.jar 文件放在`src`文件夹中。

# 配置选项

您可以通过修改 `Othello.java` 中的常量来自定义游戏的各个方面：

- `APPLICATION_WIDTH` 和 `APPLICATION_HEIGHT`：窗口大小（默认：600x600）
- `BOARD_PADDING`：棋盘周围的空间（默认：0.03）
- `CELL_PADDING`：每个单元格内的空间（默认：0.10）
- `ORDER`：棋盘阶数（默认：4，创建 8x8 棋盘）

`Display.java` 中可自定义的颜色：
- `SIDE_COLOR`：边框颜色（默认：深灰蓝 - RGB(23, 32, 42)）
- `CENTER_COLOR`：棋盘颜色（默认：钢青 - RGB(52, 73, 9)）

#其他语言

- [English](README.md)

