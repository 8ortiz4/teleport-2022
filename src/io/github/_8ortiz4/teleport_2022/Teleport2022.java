package io.github._8ortiz4.teleport_2022;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import io.github._8ortiz4.teleport_2022.Metrics;

public class Teleport2022 extends JavaPlugin {
    Map<String, String> curr = new HashMap<String, String>();
    Map<String, Long> cd = new HashMap<String, Long>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        int pluginId = 13480;
        Metrics metrics = new Metrics(this, pluginId);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = null;

        if(sender instanceof Player) {
            p = (Player) sender;
        }

        if(cmd.getName().equalsIgnoreCase("tpa")) {
            if(!(p == null)) {
                int cooldown = getConfig().getInt("configuration.cooldown");

                if(cd.containsKey(p.getName())) {
                    long diff = (System.currentTimeMillis() - cd.get(sender.getName())) / 1000;

                    if(diff < cooldown) {
                        p.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.college")), cooldown));
                        return false;
                    }
                }

                if(args.length > 0) {
                    final Player t = getServer().getPlayer(args[0]);
                    long ka = getConfig().getLong("configuration.keepalive");

                    if(t == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.problem")));
                        return false;
                    }

                    if(t == p) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.finding")));
                        return false;
                    }

                    send(p, t);

                    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                        public void run() {
                            tmo(t.getName());
                        }
                    }, ka);

                    cd.put(p.getName(), System.currentTimeMillis());
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.setting")));
                }
            } else {
                return false;
            }

            return true;
        }

        if(cmd.getName().equalsIgnoreCase("tpreject")) {
            if(!(p == null)) {
                if(curr.containsKey(p.getName())) {
                    Player r = getServer().getPlayer(curr.get(p.getName()));
                    curr.remove(p.getName());

                    if(!(r == null)) {
                        r.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.hearing")), p.getName()));
                        p.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.fishing")), r.getName()));
                        return true;
                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.clothes")));
                    return false;
                }
            } else {
                return false;
            }

            return true;
        }

        if(cmd.getName().equalsIgnoreCase("tpaccept")) {
            if(!(p == null)) {
                if(curr.containsKey(p.getName())) {
                    Player a = getServer().getPlayer(curr.get(p.getName()));
                    curr.remove(p.getName());

                    if(!(a == null)) {
                        a.teleport(p);
                        a.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.society")), p.getName()));
                        p.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.airport")), a.getName()));
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.student")));
                        return false;
                    }
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.clothes")));
                    return false;
                }
            } else {
                return false;
            }

            return true;
        }

        return false;
    }

    public void send(Player sender, Player recipient) {
        sender.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.charity")), recipient.getName()));
        World w = recipient.getWorld();

        if(recipient.hasPermission("teleport_2022.tpreject") && recipient.hasPermission("teleport_2022.tpaccept")) {
            w.playSound(recipient.getLocation(), Sound.valueOf(getConfig().getString("sounds.request")), 10, 1);
            recipient.sendMessage(String.format(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.physics")), sender.getName()));
            curr.put(recipient.getName(), sender.getName());
        }
    }

    public boolean tmo(String key) {
        if(curr.containsKey(key)) {
            Player i = getServer().getPlayer(curr.get(key));

            if(!(i == null)) {
                i.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.alcohol")));
            }

            curr.remove(key);
            return true;
        } else {
            return false;
        }
    }
}
