# PrimaxTeamGlow

**PrimaxTeamGlow** is a simple PaperMC plugin that highlights team members with a glow, visible only to their teammates.  
This plugin is built using the [BetterTeams](https://www.spigotmc.org/resources/better-teams.17129/) API to determine teams and the [GlowingEntities](https://github.com/SkytAsul/GlowingEntities) API to apply per-player colored glowing effects.

---

## ✨ Features
- Automatically detects teammates and makes them glow for each other.
- Glow is **per-player** — only your teammates glow for you.
- Updates every second to ensure team changes are reflected immediately.
- Fully integrates with **BetterTeams** for team management.
- Uses **GlowingEntities** for smooth, colored glow effects without using scoreboards or packets manually.

---

## 📦 Dependencies
This plugin requires the following dependencies to be installed on your server:
- [BetterTeams](https://www.spigotmc.org/resources/better-teams.17129/) — Team management system.

Make sure plugin is present in your `/plugins` folder before running **PrimaxTeamGlow**.

---

## 🔧 Installation
1. Download the latest `PrimaxTeamGlow.jar`.
2. Place it in your server's `/plugins` folder.
3. Install **BetterTeams**.
4. Restart the server.
5. Enjoy glowing teammates!

---

## 🛠 How It Works
- Every second, the plugin checks all online players.
- If two players are in the same BetterTeams team:
  - They will glow for each other using the GlowingEntities API.
- If they are not in the same team:
  - The glow effect is removed for that viewer.

---

## 📜 Credits
- **BetterTeams** by [booksaw](https://www.spigotmc.org/resources/better-teams.17129/) — Team system used to determine player relationships.
- **GlowingEntities** by [SkytAsul](https://github.com/SkytAsul/GlowingEntities) — Library for colored per-player entity glow.

---

## 📄 License
This plugin is distributed under the MIT License.
