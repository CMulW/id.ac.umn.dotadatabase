package id.ac.umn.dotadatabase;

import java.io.Serializable;

public class DotaData {
    interface DataBank{
        public String[] getTexts();
        public int[] getResourceIds();
    }
    public static class StrengthHeroesData implements DataBank, Serializable{
        public static String[] strings = {"Abbadon", "Alchemist", "Axe", "Beastmaster", "Brewmaster", "Bristleback", "Centaur Warruner", "Chaos Knight", "Clockwerk", "Dawnbreaker", "Doom", "Dragon Knight", "Earth Spirit", "Earthshaker", "Elder Titan", "Huskar", "Io", "Kunkka", "Legion Commander", "Lifestealer", "Lycan", "Magnus", "Mars", "Night Stalker", "Omniknight", "Phoenix", "Pudge", "Sand King", "Slardar", "Snapfire", "Spirit Breaker", "Sven", "Tidehunter", "Timbersaw", "Tiny", "Treant Protector", "Tusk", "Underlord", "Undying", "Wraith King"};
        public static int[] resourceIds = {R.drawable.abba, R.drawable.alchemist, R.drawable.axe, R.drawable.beastmaster, R.drawable.brewmaster, R.drawable.bristleback, R.drawable.centaur, R.drawable.chaos_knight, R.drawable.clockwerk, R.drawable.dawnbreaker, R.drawable.doom, R.drawable.dragon_knight, R.drawable.earth_spirit, R.drawable.earthshaker, R.drawable.elder_titan, R.drawable.huskar, R.drawable.io, R.drawable.kunkka, R.drawable.legion, R.drawable.lifestealer, R.drawable.lycan, R.drawable.magnus, R.drawable.mars, R.drawable.night_stalker, R.drawable.omni, R.drawable.phoenix, R.drawable.pudge, R.drawable.sand_king, R.drawable.slardar, R.drawable.snapfire, R.drawable.spirit_breaker, R.drawable.sven, R.drawable.tidehunter, R.drawable.timber, R.drawable.tiny, R.drawable.treant, R.drawable.tusk, R.drawable.underlord, R.drawable.undying, R.drawable.wraith};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class AgilityHeroesData implements DataBank, Serializable{
        public static String[] strings = {"Anti Mage", "Arc Warden", "Bloodseeker", "Bounty Hunter", "Broodmother", "Clinkz", "Drow Ranger", "Ember Spirit", "Faceless Void", "Gyrocopter", "Hoodwink", "Juggernaut", "Lone Druid", "Luna", "Medusa", "Meepo", "Mirana", "Monkey King", "Morphling", "Naga Siren", "Nyx Assassin", "Pangolier", "Phantom Assassin", "Phantom Lancer", "Razor", "Riki", "Shadow Fiend", "Slark", "Sniper", "Spectre", "Templar Assassin", "Terrorblade", "Troll Warlord", "Ursa", "Vengeful Spirit", "Venomancer", "Viper", "Weaver"};
        public static int[] resourceIds = {R.drawable.anti_mage, R.drawable.arc, R.drawable.blood, R.drawable.bounty, R.drawable.brood, R.drawable.clinkz, R.drawable.drow, R.drawable.ember, R.drawable.faceless, R.drawable.gyro, R.drawable.hoodwink, R.drawable.jugger, R.drawable.lone, R.drawable.luna, R.drawable.medusa, R.drawable.meepo, R.drawable.mirana, R.drawable.monkey, R.drawable.morph, R.drawable.naga, R.drawable.nyx, R.drawable.pango, R.drawable.phantom_assassin, R.drawable.phantom_lancer, R.drawable.razor, R.drawable.riki, R.drawable.shadow_fiend, R.drawable.slark, R.drawable.sniper, R.drawable.spectre, R.drawable.templar, R.drawable.terrorblade, R.drawable.troll, R.drawable.ursa, R.drawable.venge, R.drawable.venom, R.drawable.viper, R.drawable.weaver};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class IntelligenceHeroesData implements DataBank, Serializable{
        public static String[] strings = {"Ancient Apparition", "Bane", "Batrider", "Chen", "Crystal Maiden", "Dark Seer", "Dark Willow", "Dazzle", "Death Prophet", "Disruptor", "Enchantress", "Enigma", "Grimstroke", "Invoker", "Jakiro", "Keeper of the Light", "Leshrac", "Lich", "Lina", "Lion", "Nature Prophet", "Necrophos", "Ogre Magi", "Oracle", "Outworld Devourer", "Puck", "Pugna", "Queen of Pain", "Rubick", "Shadow Demon", "Shadow Shaman", "Silencer", "Skywrath Mage", "Storm Spirit", "Techies", "Tinker", "Visage", "Void Spirit", "Warlock", "Windranger", "Winter Wyvern", "Witch Doctor", "Zeus"};
        public static int[] resourceIds = {R.drawable.ancient_apparition, R.drawable.bane, R.drawable.bat, R.drawable.chen, R.drawable.crystal, R.drawable.dark_seer, R.drawable.dark_willow, R.drawable.dazzle, R.drawable.death_prophet, R.drawable.disruptor, R.drawable.enchan, R.drawable.enigma, R.drawable.grim, R.drawable.invok, R.drawable.jakiro, R.drawable.kotl, R.drawable.lesh, R.drawable.lich, R.drawable.lina, R.drawable.lion, R.drawable.nature, R.drawable.necro, R.drawable.ogre, R.drawable.oracle, R.drawable.outworld, R.drawable.puck, R.drawable.pugna, R.drawable.qop, R.drawable.rubick, R.drawable.shadow_demon, R.drawable.shadow_shaman, R.drawable.silencer, R.drawable.skywrath, R.drawable.storm, R.drawable.techies, R.drawable.tinker, R.drawable.visage, R.drawable.void_spirit, R.drawable.warlock, R.drawable.windranger, R.drawable.winter, R.drawable.witch, R.drawable.zeus};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
}
