# QOLCommandsPlugin  
This is a Quality of Life Plugin for Minecraft that adds useful commands to improve gameplay.

## Overview  
Currently, there are 4 commands available:

- `/heal` — Restores your health to full. Requires permission `qolcommands.heal`.  
- `/feed` — Fills your hunger bar completely. Requires permission `qolcommands.feed`.  
- `/repair` — Repairs the item you’re holding. Requires permission `qolcommands.repair`.  
- `/gamemode <0-3|name>` — Changes your game mode using the classic Minecraft numbers (0 = Survival, 1 = Creative, 2 = Adventure, 3 = Spectator) or the usual game mode names. Requires permission `qolcommands.gamemode`.  
  *This command brings back the original numeric way to switch game modes!*

## Installation  
1. Download the latest release from the Releases section.  
2. Place the `.jar` file into your server's `plugins` folder.  
3. Restart your server or run `/reload`.  

## Permissions  
Each command requires a specific permission node:

| Command      | Permission              |  
|--------------|-------------------------|  
| `/heal`      | `qolcommands.heal`       |  
| `/feed`      | `qolcommands.feed`       |  
| `/repair`    | `qolcommands.repair`     |  
| `/gamemode`  | `qolcommands.gamemode`   |  

There is also a wildcard permission: `qolcommands.*` — this grants access to **all commands** and is by default assigned to server operators (`op`).

Make sure to assign the appropriate permissions to your players or groups via your permissions plugin.

## Usage  
Use the commands directly in-game or in the console. Make sure you have the necessary permissions.
