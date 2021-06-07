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

    public static class ConsumablesData implements DataBank, Serializable{
        public static String[] strings = {"Aghanim's Shard", "Bottle", "Clarity", "Dust of Appearance", "Enchanted Mango", "Faerie Fire", "Healing Salve", "Observer Ward", "Sentry Ward", "Smoke of Deceit", "Tango", "Tome of Knowledge", "Town Portal Scroll"};
        public static int[] resourceIds = {R.drawable.agha_shard, R.drawable.bottle, R.drawable.clarity, R.drawable.dust, R.drawable.enchanted_mango, R.drawable.faerie_fire, R.drawable.healing_salve, R.drawable.obs_ward, R.drawable.sentry_ward, R.drawable.smoke, R.drawable.tango, R.drawable.tome, R.drawable.tp_scroll};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class AttributesData implements DataBank, Serializable{
        public static String[] strings = {"Band of Elvenskin", "Belt of Strength", "Blade of Alacrity", "Circlet", "Crown", "Gauntlets of Strength", "Iron Branch", "Mantle of Intelligence", "Ogre Axe", "Robe of the Magi", "Slippers of Agility", "Staff of Wizardry"};
        public static int[] resourceIds = {R.drawable.band_of_elvenskin, R.drawable.belt_of_strength, R.drawable.blade_of_alacrity, R.drawable.circlet, R.drawable.crown, R.drawable.gauntlet_of_strength, R.drawable.iron_branch, R.drawable.mantle_of_intelligence, R.drawable.ogre_axe, R.drawable.robe_of_magi, R.drawable.slippers_of_agility, R.drawable.staf_of_wizardry};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class EquipmentData implements DataBank, Serializable{
        public static String[] strings = {"Blades of Attack", "Blight Stone", "Broadsword", "Chainmail", "Claymore", "Gloves of Haste", "Helm of Iron Will", "Infused Raindrop", "Javelin", "Mithril Hammer", "Orb of Venom", "Quarterstaff", "Quelling Blade", "Ring of Protection"};
        public static int[] resourceIds = {R.drawable.blade_of_attack, R.drawable.blight, R.drawable.broadsword, R.drawable.chainmail, R.drawable.claymore, R.drawable.gloves_of_haste, R.drawable.helm_of_ironwill, R.drawable.infused_raindrop, R.drawable.javelin, R.drawable.mithril, R.drawable.orb_of_venom, R.drawable.quarterstaff, R.drawable.quelling, R.drawable.rop};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class MiscData implements DataBank, Serializable{
        public static String[] strings = {"Blink Dagger", "Blitz Knuckles", "Boots of Speed", "Cloak", "Fluffy Hat", "Gem of True Sight", "Ghost Scepter", "Magic Stick", "Morbid Mask", "Ring of Regen", "Sage's Mask", "Shadow Amulet", "Voodoo Mask", "Wind Lace"};
        public static int[] resourceIds = {R.drawable.blink, R.drawable.blitz, R.drawable.boots_plain, R.drawable.cloak, R.drawable.fluffy, R.drawable.gem, R.drawable.ghost_scepter, R.drawable.magic_stick, R.drawable.morbid, R.drawable.ring_of_regen, R.drawable.sage_mask, R.drawable.shadow_amulet, R.drawable.voodoo, R.drawable.wind_lace};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class SecretData implements DataBank, Serializable{
        public static String[] strings = {"Demon Edge", "Eaglesong", "Energy Booster", "Hyperstone", "Mystic Staff", "Platemail", "Point Booster", "Reaver", "Ring of Health", "Sacred Relic", "Talisman of Evasion", "Ultimate Orb", "Vitality Booster", "Void Stone"};
        public static int[] resourceIds = {R.drawable.demon_edge, R.drawable.eaglesong, R.drawable.energy, R.drawable.hyperstone, R.drawable.mystic, R.drawable.platemail, R.drawable.point_booster, R.drawable.reaver, R.drawable.ring_of_health, R.drawable.sacred_relic, R.drawable.talisman, R.drawable.ultimate_orb, R.drawable.vitality, R.drawable.void_stone};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class RoshanData implements DataBank, Serializable{
        public static String[] strings = {"Aegis of the Immortal", "Aghanim's Blessing", "Cheese", "Refresher Shard"};
        public static int[] resourceIds = {R.drawable.aegis, R.drawable.aghanim_scepter_rs, R.drawable.cheese, R.drawable.refresher_shard};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class AccessoriesData implements DataBank, Serializable{
        public static String[] strings = {"Boots of Travel", "Bracer", "Falcon Blade", "Hand of Midas", "Helm of the Dominator", "Helm of the Overlord", "Magic Wand", "Mask of Madness", "Moon Shard", "Null Talisman", "Oblivion Staff", "Orb of Corrosion", "Perseverance", "Phase Boots", "Power Treads", "Soul Ring", "Wraith Band"};
        public static int[] resourceIds = {R.drawable.boots_of_travel, R.drawable.bracer, R.drawable.falcon, R.drawable.hand_of_midas, R.drawable.helm_domi, R.drawable.helm_overlord, R.drawable.magic_wand, R.drawable.mask_of_madness, R.drawable.moon_shard, R.drawable.null_talis, R.drawable.oblivion, R.drawable.orb_of_corrosion, R.drawable.perseverance, R.drawable.phase_boots, R.drawable.power_treads, R.drawable.soul_ring, R.drawable.wraith_band};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class SupportData implements DataBank, Serializable{
        public static String[] strings = {"Arcane Boots", "Buckler", "Drum of Endurance", "Guardian Greaves", "Headdress", "Holy Locket", "Medallion of Courage", "Mekansm", "Pipe of Insight", "Ring of Basilius", "Spirit Vessel", "Tranquil Boots", "Urn of Shadows", "Vladmir's Offering"};
        public static int[] resourceIds = {R.drawable.arcane_boots, R.drawable.buckler, R.drawable.drum, R.drawable.guard_greaves, R.drawable.headdress, R.drawable.holy_locket, R.drawable.medallion, R.drawable.mekkans, R.drawable.pipe, R.drawable.ring_basill, R.drawable.spirit_vessel, R.drawable.tranquil, R.drawable.urn, R.drawable.vlad};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class MagicalData implements DataBank, Serializable{
        public static String[] strings = {"Aether Lens", "Aghanims's Scepter", "Dagon", "Eul's Scepter of Divinity", "Force Staff", "Gleipnir", "Glimmer Cape", "Octarine Core", "Refresher Orb", "Rod of Atos", "Scythe of Vyse", "Solar Crest", "Veil of Discord", "Wind Walker", "Witch Blade"};
        public static int[] resourceIds = {R.drawable.aether, R.drawable.aghs, R.drawable.dagon, R.drawable.eul, R.drawable.force_staff, R.drawable.gleipnir, R.drawable.glimmer, R.drawable.octarine, R.drawable.refresher, R.drawable.rod_atos, R.drawable.scythe, R.drawable.solar, R.drawable.veil, R.drawable.wind_walker, R.drawable.witch_blade};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class ArmorData implements DataBank, Serializable{
        public static String[] strings = {"Aeon Disk", "Assault Cuirass", "Black King Bar", "Blade Mail", "Bloodstone", "Crimson Guard", "Eternal Shroud", "Heart of Tarrasque", "Hood of Defiance", "Hurricane Pike", "Linken's Sphere", "Lotus Orb", "Manta Style", "Shiva's Guard", "Soul Booster", "Vanguard"};
        public static int[] resourceIds = {R.drawable.aeon, R.drawable.assault, R.drawable.black_king, R.drawable.blademail, R.drawable.bloodstone, R.drawable.crimson_guard, R.drawable.eternal, R.drawable.heart, R.drawable.hood, R.drawable.hurricane, R.drawable.linken, R.drawable.lotus, R.drawable.manta, R.drawable.shiva, R.drawable.soul_booster, R.drawable.vanguard};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class WeaponData implements DataBank, Serializable{
        public static String[] strings = {"Abyssal Blade", "Armlet of Mordiggian", "Battle Fury", "Bloodthorn", "Butterfly", "Crystalys", "Daedalus", "Desolator", "Divine Rapier", "Ethereal Blade", "Meteor Hammer", "Monkey King Bar", "Nullifier", "Radiance", "Shadow Blade", "Silver Edge", "Skull Basher"};
        public static int[] resourceIds = {R.drawable.abyssal, R.drawable.armlet, R.drawable.battle, R.drawable.bloodthorn, R.drawable.butter, R.drawable.crystal, R.drawable.daedalus, R.drawable.desolator, R.drawable.divine_rapier, R.drawable.ethereal, R.drawable.meteor, R.drawable.mkb, R.drawable.nullifier, R.drawable.radiance, R.drawable.shadowblade, R.drawable.silver, R.drawable.skull};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class ArtifactsData implements DataBank, Serializable{
        public static String[] strings = {"Arcane Blink", "Diffusal Blade", "Dragon Lance", "Echo Sabre", "Eye of Skadi", "Heaven's Halberd", "Kaya", "Kaya and Sange", "Maelstorm", "Mage Slayer", "Mjolnir", "Overwhelming Blink", "Sange", "Sange and Yasha", "Swift Blink", "Yasha", "Yasha and Kaya"};
        public static int[] resourceIds = {R.drawable.arcane_blink, R.drawable.diffusal, R.drawable.dragon_lance, R.drawable.echo, R.drawable.eos, R.drawable.heaven_halberd, R.drawable.kaya, R.drawable.kaya_sange, R.drawable.maelstorm, R.drawable.mage_slayer, R.drawable.mjolnir, R.drawable.overwhelming, R.drawable.sange, R.drawable.sange_yasha, R.drawable.swift_blink, R.drawable.yasha, R.drawable.yasha_kaya};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class Tier1Data implements DataBank, Serializable{
        public static String[] strings = {"Arcane Ring", "Broom Handle", "Chipped Vest", "Faded Broach", "Fairy's Trinket", "Ironwood Tree", "Keen Optic", "Ocean Heart", "Possessed Mask", "Trusty Shovel"};
        public static int[] resourceIds = {R.drawable.arcane_ring, R.drawable.broom, R.drawable.chipped, R.drawable.faded, R.drawable.fairy_trinket, R.drawable.ironwood, R.drawable.keen, R.drawable.ocean, R.drawable.pos_mask, R.drawable.trusty};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class Tier2Data implements DataBank, Serializable{
        public static String[] strings = {"Bullwhip", "Dragon Scale", "Essence Ring", "Grove Bow", "Imp Claw", "Nether Shawl", "Philosopher's Stone", "Pupil's Gift", "Quicksilver Amulet", "Ring of Aquila"};
        public static int[] resourceIds = {R.drawable.bullwhip, R.drawable.dragon_scale, R.drawable.essence, R.drawable.grove, R.drawable.imp, R.drawable.nether, R.drawable.philosopher, R.drawable.pupils, R.drawable.quicksilver, R.drawable.aquila};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class Tier3Data implements DataBank, Serializable{
        public static String[] strings = {"Ceremonial Robe", "Cloak of Flames", "Elven Tunic", "Enchanted Quiver", "Mind Breaker", "Orb of Destruction", "Paladin Sword", "Psychic Headband", "Quickening Charm", "Spider Legs", "Titan Sliver"};
        public static int[] resourceIds = {R.drawable.ceremonial, R.drawable.cloak_of_flames, R.drawable.elven, R.drawable.enchanted_quiver, R.drawable.mind_breaker, R.drawable.orb_of_destruction, R.drawable.paladin, R.drawable.pyshic, R.drawable.quickening, R.drawable.spider, R.drawable.titan};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class Tier4Data implements DataBank, Serializable{
        public static String[] strings = {"Flicker", "Illusionist's Cape", "Minotaur Horn", "Ninja Gear", "Penta-Edged Sword", "Spell Prism", "Stormcrafter", "Telescope", "The Leveller", "Timeless Relic", "Trickster Cloak"};
        public static int[] resourceIds = {R.drawable.flicker, R.drawable.illusionist, R.drawable.minotaur, R.drawable.ninja_gear, R.drawable.penta_edge, R.drawable.spell_prism, R.drawable.stormcrafter, R.drawable.telescope, R.drawable.leveller, R.drawable.timeless, R.drawable.trickster};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
    public static class Tier5Data implements DataBank, Serializable{
        public static String[] strings = {"Apex", "Ballista", "Book of Shadows", "Book of the Dead", "Ex Machina", "Fallen Sky", "Force Boots", "Giant's Ring", "Mirror Shield", "Pirate Hat", "Seer Stone", "Stygian Desolator"};
        public static int[] resourceIds = {R.drawable.apex, R.drawable.ballista, R.drawable.book_of_shadows, R.drawable.book_of_the_dead, R.drawable.ex_machina, R.drawable.fallen_sky, R.drawable.force_boots, R.drawable.giant_ring, R.drawable.mirror_shield, R.drawable.pirate, R.drawable.seer_stone, R.drawable.stygian};
        @Override public String[] getTexts() { return strings; }
        @Override public int[] getResourceIds() { return resourceIds; }
    }
}