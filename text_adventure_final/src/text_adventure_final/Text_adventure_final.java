package text_adventure_final;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Text_adventure_final {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("          _______  _______ _________ _       _________ _______ \r\n" + 
				"|\\     /|(  ___  )(  ____ \\\\__   __/( \\      \\__   __/(  ____ \\\r\n" + 
				"| )   ( || (   ) || (    \\/   ) (   | (         ) (   | (    \\/\r\n" + 
				"| |   | || (___) || (_____    | |   | |         | |   | (_____ \r\n" + 
				"( (   ) )|  ___  |(_____  )   | |   | |         | |   (_____  )\r\n" + 
				" \\ \\_/ / | (   ) |      ) |   | |   | |         | |         ) |\r\n" + 
				"  \\   /  | )   ( |/\\____) |___) (___| (____/\\___) (___/\\____) |\r\n" + 
				"   \\_/   |/     \\|\\_______)\\_______/(_______/\\_______/\\_______)\r\n" + 
				"                                                               ");
		System.out.println("Created by Gabriel Carlile");
		System.out.println("Inspired by D&D 5E from Wizards of the Coast");
		//Also this is a complete rip off of the pacific rim plot which i did not realize until like half way through making the game
		
		//race and class/archetype determine the players stats and moves in combat
		
				int race;
				int archetype = 0;
				
				/*
				 *in my game I've used the stat system from d&d 5e where you have six primary
				 *stats: strength, dexterity, constition, intelligence, charisma, and wisdom.
				 *stats are used not only for comabt, but also if a player choses to do something
				 *like jump over a fence or persuade somebody to do something ect.
				 */
				
				int STR = 0;
				int DEX = 0;
				int CON = 0;
				int INT = 0;
				int CHA = 0;
				int WIS = 0;
				
				/*
				 * in this combat system, every attack has two parts; the role to hit, and damage
				 * when the player attacks they "role" a number between 1 and 20, plus the appropriate
				 * stat modifier. if the combined value of the role plus the modifier exceeds the enemies
				 * AC, or Armor Class, they hit and than do damage. if they do not beat the AC they miss
				 * damage is determined by the specific attack. this same system applies for when an
				 * enemy attacks the player.
				 */
				
				int enemy1HP=12;
				int enemy2HP=15;
				
				int Act1P1;
				int Act2P1;
				int Act1P2 = 0;
				int Act2P2;
				
				int CharCus = 0;
				
				int AC = 0;
				int MaxHP = 0;
				int CurrentHP;
				int StatImprov;
				
				/*
				 * not all rolls use TheRoll20 variable, some (like healing) might use TheRole8
				 * of TheRoll6 variables instead
				 */
				
				int TheRoll20 = 0;
				int TheRoll10 = 0;
				int TheRoll8 = 0;
				int TheRoll6 = 0;
				
				/* the choice variable is used to hold the choice a player makes when given two 
				*different options
				*/
				int Choice;
				
				while(CharCus==0) {
				System.out.println("");
				System.out.println("Please choose your Race");
				System.out.println("Human(1)");
				System.out.println("Elf(2)");
				System.out.println("Dwarf(3)");
				System.out.println("Halfling(4)");
				race = input.nextInt();
				System.out.println("Please choose your Class");
				System.out.println("Brawler, tough as nails and packing a punch that anybody with a brain would avoid.(1)");
				System.out.println("Spell Slinger, shooting blasts of flame and thunder and looking cool while doing it.(2)");
				System.out.println("Street Preacher, somebody with the wisdom of the city whos out to help out others.(3)");
				System.out.println("Alley Man, slippery and not entirely trustwothy they're always looking out for themselves.(4)");
				archetype = input.nextInt();
				
				System.out.println("Please selecet one stat to improve:");
				System.out.println("Strength(1)");
				System.out.println("Dexterity(2)");
				System.out.println("Constition(3)");
				System.out.println("Intelligence(4)");
				System.out.println("Wisdom(5)");
				System.out.println("Charisma(6)");
				StatImprov = input.nextInt();
				
				if(StatImprov==1) {
				STR = STR + 1;
				}
				if(StatImprov==2) {
					DEX = DEX + 1;
					}
				if(StatImprov==3) {
					CON = CON + 1;
					}
				if(StatImprov==4) {
					INT = INT + 1;
					}
				if(StatImprov==5) {
					WIS = WIS + 1;
					}
				if(StatImprov==6) {
					CHA = CHA + 1;
					}
				
				/*
				 * the player's stat block is determined by their race and class/archetype
				 */
				
				if(race == 1){
					STR = STR+1;
					DEX = DEX+1;
					CON = CON+0;
					INT = INT+2;
					CHA = CHA+0;
					WIS = WIS-2;
				}
				
				if(race == 2) {
					STR = STR-1;
					DEX = DEX+1;
					CON = CON-2;
					INT = INT+1;
					CHA = CHA+1;
					WIS = WIS+1;
					}
				if(race == 3) {
					STR = STR+1;
					DEX = DEX+0;
					CON = CON+2;
					INT = INT+0;
					CHA = CHA-1;
					WIS = WIS+0;
					}
				if(race == 4) {
					STR = STR+0;
					DEX = DEX+2;
					CON = CON+0;
					INT = INT-1;
					CHA = CHA+2;
					WIS = WIS-1;
					}
				if(archetype == 1){
					AC = 14;
					MaxHP = 12 + CON;
					STR = STR+2;
					CON = CON+1;
					Act1P1 = TheRoll20 + STR;
					Act2P1 = 8 + STR;
					Act1P2 = TheRoll20 + DEX;
					Act2P2 = 6 + DEX;
					}
				
				if(archetype == 2) {
					AC = 9;
					MaxHP = 8+CON;
					INT = INT+2;
					WIS = WIS+1;
					Act1P1 = TheRoll20 + INT;
					Act2P1 = 12 + INT;
					Act1P2 = TheRoll6 + INT;
					}
				
				if(archetype == 3) {
					AC = 12;
					MaxHP = 10+CON;
					WIS = WIS+2;
					CHA = CHA+1;
					Act1P1 = TheRoll20 + WIS;
					Act2P1 = 9+WIS;
					Act1P2 = TheRoll8 + WIS;
					}
				
				if(archetype == 4) {
					AC = 10;
					MaxHP = 9 + CON;
					DEX = DEX+2;
					INT = INT+1;
					Act1P1 = TheRoll20 + DEX;
					Act2P1 = 8 + DEX;
					Act1P2 = TheRoll20 + DEX;
					Act2P2 = 6 + DEX + DEX;	
					}
				
				System.out.println("Your Stats:");
				System.out.println("HP:" + MaxHP);
				System.out.println("Armor Class:" + AC);
				System.out.println("Strength:" + STR);
				System.out.println("Dexterity:" + DEX);
				System.out.println("Constitution:" + CON);
				System.out.println("Intelligence:" + INT);
				System.out.println("Wisdom:" + WIS);
				System.out.println("Charisma:" + CHA);
				System.out.println("Is this Okay? Yes(1) No(2)");
				Choice = input.nextInt();
				if(Choice == 1){
					CharCus = CharCus + 1;
				}
				}
System.out.println("                      .|\r\n" + 
		"                       | |\r\n" + 
		"                       |'|            ._____\r\n" + 
		"               ___    |  |            |.   |' .---\"|\r\n" + 
		"       _    .-'   '-. |  |     .--'|  ||   | _|    |\r\n" + 
		"    .-'|  _.|  |    ||   '-__  |   |  |    ||      |\r\n" + 
		"    |' | |.    |    ||       | |   |  |    ||      |\r\n" + 
		" ___|  '-'     '    \"\"       '-'   '-.'    '`      |____\r\n" + 
		"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
System.out.println("New York, New York.\r\n" + 
		"November 8th, 2025.\r\n" + 
		"5:00 AM.\r\n" + 
		"Midtown Manhattan.\r\n" +
		"Inside the Wall." + 
		"You’re jolted up by the sound of your alarm as you reach over and slap your hand on your phone shutting it off. You \r\n"
		+ "Groggily rub your eyes and spread the blinds covering your window. It’s still dark out, dark of course being a \r\n"
		+ "relative term, seeing as the streets of Midtown are brightly illuminated by the lights of Manhattan. They don’t \r\n"
		+ "call it the city that never sleeps for nothing. In the distance you see the wall. The wall that strethces from \r\n"
		+ "Maine to Florida. The wall that they built in 1995 completly of reinforced titanium. The wall that costed the \r\n"
		+ "U.S nearly a hundred-billion dollars to build. The wall that at its highest stretches nearly eight hundred feet, \r\n"
		+ "and at its thickest, nearly a hundred feet.\r\n"
		+ "The wall you work at. The wall they built to keep out the beasts.\r\n"
		+ " You turn back and flip the light switch. The room is dimly \r\n"
		+ "illuminated by dingy yellow light exposing the cobwebs and dust bunnies that camp out in the corners of \r\n"
		+ "your room. You glance around the small one room apartment you \r\n"
		+ "call home. The walls are made of exposed brick and the ceiling is an ugly yellow from years of water damage. The \r\n"
		+ "floors are made of a dusty wood paneling, not that you can see them, in a Manhattan apartment you have to utilize \r\n"
		+ "every square inch of floor and wall space. The room is so small you can almost touch both walls at the same time. \r\n"
		+ "Your old twin bed is pushed up against the farthest wall under the one window in the room, you have a tall \r\n"
		+ "dresser, a desk and laptop, a very small table, a bookshelf, along with a sink, oven, coffee machine, microwave,\r\n"
		+ " a toaster sitting on the microwave, a mini fridge and a few cupboards all crammed into a small space.  Dirty \r\n"
		+ "clothes and dishes are lay scattered around the room and a pile of mail sits on your desk. A large brown \r\n"
		+ "envelope on top of the pile says RENT in big red letters. The sink quietly drips on the other side of the room,\r\n"
		+ " and the busy street noise streams in through your window. You slide out of bed and go to put some coffee on the \r\n"
		+ "pot. You pull out the coffee mix and scrape out the last bit. While the coffee brews, you open up the mini fridge \r\n"
		+ "and look inside. Almost completely barren with the exception of some white bread, a half empty carton of milk, \r\n"
		+ "and a bottle of ketchup.");
System.out.println("Ketchup on toasted bread(1), or just coffee(2)?");
Choice = input.nextInt();
if(Choice==1) {
	System.out.println("You grab two pieces of bread and slap them into the toaster. A few moments later they pop up and\r\n"
			+ " you slather them in a generous amount of ketchup. You do your best to wash down each bite with a gulp of \r\n"
			+ "coffee, but there’s only so much and you have to finish the last few bites coffee-less. ");
		}
if(Choice==2) {
	System.out.println("Yah I think I would’ve just stuck to coffee too. Talk about an all time low.");
		}
System.out.println("After finishing, you open up your dresser and change into some street clothes and sling your gear \r\n"
		+ "bag over your shoulder. You grab your phone and wallet and are about to head out the door when there is a \r\n"
		+ "knocking on the other side, you look through the peep hole and at first don’t see anything until you see a \r\n"
		+ "small gnome jumping to reach the peep hole. You immediately recognize him as your landlord, Marshall ‘Come \r\n"
		+ "on I know you’re in there’ he says ‘You two months behind on rent open up’.\r\n"
		+ "Open up(1), or go out through the fire escape(2)?");
Choice = input.nextInt();
if(Choice==1) {
	System.out.println("You creek the door open and look down at him. He has deep green hair that is slicked back, a \r\n"
			+ "handful of peircing in either ear, and a short goatee an equal shade of green. His eyes are slightly \r\n"
			+ "sunken and his nose is hooked. He sighs and looks up at you 'Listen, I know times are hard for you \r\n"
			+ "right now financialy and all. But you havn't paid rent sense August. If you keep this up I'm going \r\n"
			+ "to have no option but to evict you'. He pauses and waits for your response");
	System.out.println("Apologize and promise the money(1), or try and buy more time(2)?");
	Choice = input.nextInt();
	if(Choice==1) {
		System.out.println("You're eyes lower to the floor 'Yah I know' you say not meeting his eyes 'I'll get you \r\n"
				+ "you the money as soon  as I get it'. He takes only a moment 'I hope so' he says with a regretful \r\n"
				+ "sigh 'For your sake. You have forty-eight hours.' He turns and walks down the hall without \r\n"
				+ "another word. You turn and walk the opposite direction, you really need some cash.");
			}
	if(Choice==2) {
		System.out.println("'Listen' you say with confidence'Mercenaries like myself are out on the other side of the wall to make \r\n"
				+ "sure this city stays safe because the military isn't willing to do what we do. Work is slow right \r\n"
				+ "now, but you have my word, as soon as soon as I have the cash to pay off m debts I will. But \r\n"
				+ "right now is not that time.'");
		TheRoll20 = ThreadLocalRandom.current().nextInt(1,20);
		if(TheRoll20+CHA<13) {
			System.out.println("He sighs and nods 'Alright alright, I guess everyday people like us have a lot to \r\n"
					+ "thank people like you for' he says with a weak laugh 'Just make sure you get it to me \r\n"
					+ "sooner rather than later' you smile and give him a small wave 'Sure thing cheif'. He waves \r\n"
					+ "back at you as he turns and goes down the hallway. You turn and walk the opposite direction. \r\n"
					+ "That was a close one.");
				}
		else {
			System.out.println("'No, no, that isn't going to work on me' he says looking at you sternly 'Just\r\n"
					+ "because you chose to take a risk and become a mercenary doesn't mean you can't pay \r\n"
					+ "rent' you look up at the ceiling and sigh 'The rest of us have to make a living to \r\n"
					+ "too pal' he says. 'Hey, hey' he says snapping his finger for your attention \r\n"
					+ "'forty-eight hours' he says pointing at you, he starts to walk down the hallway \r\n"
					+ "still pointing at you 'forty-eight hours, or your out' he fully turns around \r\n"
					+ "continues down the hallway. You turn and walk the opposite direction. This is \r\n"
					+ "not going to go well.");
				}
			}
	System.out.println("As you exit your building, you feel the cold autumn air of Manhattan on your \r\n"
			+ "face. You look about and take in Midtown, an unflowing river of cars sit in the street \r\n"
			+ "infront of you. High above you a number of magic carpets, flying broomsticks, and other \r\n"
			+ "magic items soar across the skyline. The streets aren't packed this time of day, but \r\n"
			+ "they still manage to be crowded. You lean into the street and call 'Taxi!' waving your \r\n"
			+ "hand. A cab pulls over in front of you and you hop in. The driver, a half orc woman \r\n"
			+ "short buzzed hair, looks at you in the rear view mirror 'Where you headed?' you look \r\n"
			+ "up and reply 'just at the wall'. 'You got it boss' she says pulling back into the \r\n"
			+ "street. You sit in silence for a while, watching the beauty of New York pass you buy. \r\n"
			+ "Finally she asks 'So are you a mercenary or something? You don't look much like the  \r\n" + 
			"guards there.' you're briefly caught off guard but quickly respond to her question. \r\n" + 
			"'Yah, I've been working on the other side of the wall sense I was only fifteen or so.' \r\n" + 
			"she nods than asks 'So what's the difference between mercanaries like you and the \r\n" + 
			"guards on the wall?' you replie saying 'The guards are the last line of defense, they\r\n" + 
			"make sure none of the beasts don't actually make it into the city. We make sure that they \r\n" + 
			"never reach the wall in the first place, try and discover weaknesses and where they come \r\n" + 
			"from. Not to mention the guards are a legitimate branch of the military. We get paid by \r\n" + 
			"the city to do what we do. But the real differnce is that we are expendible, and they \r\n" + 
			"are not. Doesn't bother me to much though, it pays well. Or at least it did...'you trail \r\n" + 
			"off at this part. The job had been paying well, real well, almost enough that you were \r\n" + 
			"getting ready to move into a nicer apartment. But then, about a year ago, the beasts starting getting \r\n" + 
			"stronger. It wasn't gradual either, it used to be that a beast wouldn't reach the wall \r\n" + 
			"more than once a month, but all at once more than a dozen would reach the wall every \r\n" + 
			"day. The city took this as a sign that you no longer were worth paying you so well.\r\n" + 
			"Your wages were cut more than in half, what once was a hundred-thousand dollar salary \r\n" + 
			"was now only about forty-thousand. You think about this as the city of New York passes \r\n" + 
			"by through your window. You look up as you approach the wall. The half-orc begins to pull up at the \r\n" + 
			"gate to the wall. She looks at her fare counter than turns to you 'That'll be thirty-five \r\n" + 
			"dollars. You pull your wallet out and open it up to see the void in its main pocket. You\r\n" + 
			"give her a nervous laughter as you look up at her.");
	System.out.println("New York, New York.\r\n" + 
			"November 8th, 2025.\r\n" + 
			"7:14 AM.\r\n" + 
			"Upper East Side.\r\n" +
			"On the Wall.");
	if(CHA+9>10) {
		System.out.println("You walk through the gate and up to the wall. Luckily your a smooth talker \r\n"
				+ "and that half-orc let you off easy.");
			}
	else {
		System.out.println("You walk through the gate and up to the wall. That half-orc can throw a punch.");
			}
				}
if(Choice==2) {
	System.out.println("You turn to your window, to the door, than back to the window. Marshall continues \r\n"
			+ "to bang on the door and demanding you open up, but you pay him as you push your window up \r\n"
			+ "and climb out onto the fire escape. You breath in the crisp cold morning air, the sky is \r\n"
			+ "still dark but the city is awake as ever. Cars honk and horn as the majority of them sit \r\n"
			+ "stationary. You look up and see a number of people flying on magic carpets and flying \r\n"
			+ "broomsticks. Flying is much faster than driving but is also generally more expsensive");
	System.out.println("You whistle and wave your hand 'Taxi!' A teifling man with a turban wrapped \r\n"
			+ "around his face to keep warm pulls over to the fire escape 'Where are you headed?' he \r\n"
			+ "asks 'Just drop me off at the wall' you say as you clamber onto the carpet. 'Alright'"
			+ "he says as he pulls away from the fire escape. You ride in silence for only a few moments\r\n"
			+ "before he asks 'So are you a mercenary or something? You don't look much like the  \r\n"
			+ "guards there.' you have to speak up for him to hear you over the wind in your faces \r\n"
			+ "'Yah, I've been working on the other side of the wall sense I was only fifteen or so.' \r\n"
			+ "he nods than asks 'So what's the difference between mercanaries like you and the \r\n"
			+ "guards on the wall?' you replie saying 'The guards are the last line of defense, they \r\n"
			+ "make sure none of the beasts don't actually make it into the city. We make sure that they \r\n"
			+ "never reach the wall in the first place, try and discover weaknesses and where they come \r\n"
			+ "from. Not to mention the guards are a legitimate branch of the military. We get paid by \r\n"
			+ "the city to do what we do. But the real differnce is that we are expendible, and they \r\n"
			+ "are not. Doesn't bother me to much though, it pays well. Or at least it did...'you trail \r\n"
			+ "off at this part. The job had been paying well, real well, almost enough that you were \r\n"
			+ "getting ready to move into a nicer apartment. But then, about a year ago, the beasts starting getting \r\n"
			+ "stronger. It wasn't gradual either, it used to be that a beast wouldn't reach the wall \r\n"
			+ "more than once a month, but all at once more than a dozen would reach the wall every \r\n"
			+ "day. The city took this as a sign that you no longer were worth paying you so well. \r\n"
			+ "Your wages were cut more than in half, what once was a hundred-thousand dollar salary \r\n"
			+ "was now only about forty-thousand. You think about this as the city of New York passes \r\n"
			+ "beneath you. You look up as you approach the wall. The teifling begins to lower at the \r\n"
			+ "gate to the wall. He looks at his fare counter than turns to you 'That'll be thirty-five \r\n"
			+ "dollars. You pull your wallet out and open it up to see the void in its main pocket. You"
			+ "give him a nervous laughter as you look up at him.");
	System.out.println("New York, New York.\r\n" + 
			"November 8th, 2025.\r\n" + 
			"6:39 AM.\r\n" + 
			"Upper East Side.\r\n" +
			"On the Wall.");
	if(CHA+9>10) {
		System.out.println("You walk through the gate and up to the wall. Luckily your a smooth talker \r\n"
				+ "and that teifling let you off easy.");
			}
	else {
		System.out.println("You walk through the gate and up to the wall. That teifling can throw a punch.");
			}
		}
System.out.println("As you pass through security you show the guards, I.D and Mercanary liscence. After\r\n"
		+ "passing through multiple gates you reach the doors into the main building, a tower that juts \r\n"
		+ "out from the wall. It stands high above the rest of the wall. Before you even take one step \r\n"
		+ "into the building, Adam, a tall thin elf with platnum blonde hair and gaunt featuresis \r\n"
		+ "already talking to you 'Did you here?' he asks you continue walking through the large \r\n"
		+ "building towards the elevator. 'There was a beast sighting in Chile this morning' You stop \r\n"
		+ "dead in your tracks 'Chile? That doesn't make any sense, beasts have never come from the \r\n"
		+ "Pacific.' you say 'Yes, but we don't think they're coming from the Pacific'he says frantically\r\n"
		+ "as you both continue to the door 'if my sources are to believed, and I like to think they \r\n"
		+ "should be, it's the same beasts that were sighted in Mexico last week'"
		+ "'you mean to tell me that they can travel thousands of miles in the span of a few days?'\r\n"
		+ "you retort\r\n"
		+ "'yes, that's exactly what I'm telling you' he says as you both get into the elevator.\r\n"
		+ "'by the way, Sean wanted to talk to you about something, said it's real important'\r\n"
		+ "'I hope it's not another wild goose chase' you say under your breath' when you arrive \r\n"
		+ "up top you see Sean leaning on the wall looking out over the wastelands. Sean is tall and fit human man \r\n"
		+ "with dark skin and a faded hightop cut. He has large features and carries a large \r\n"
		+ "electric axe on his back and a handgun on his side. He's about twenty-nine and has \r\n"
		+ "been a mercanary for the wall almost as long as you have. When he sees you he \r\n"
		+ "gestures you over, when you approach he pulls out a pack of cigerettes and places \r\n"
		+ "one between his lips 'you want one?' he asks in his deep voice."
		+ "Take one(1), or refuse(2)?");
Choice = input.nextInt();
if(Choice==1) {
	System.out.println("                  (  )/  \r\n" + 
			"                    )(/\r\n" + 
			" ________________  ( /)\r\n" + 
			"()__)____________))))) ");
	System.out.println("'yah sure why not' you say taking one. Sean takes out a lighter and \r\n"
			+ "lights you both up. You take a long drag as you look over the wastelands, what \r\n"
			+ "used to be Brooklyn and Rhoad Island had been ravaged by the beasts, years\r\n"
			+ "before in 1990 before the wall was built. The wastelands\r\n"
			+ "are every where, nearly all of Deleware and New Jersey were now deserted \r\n"
			+ "evevn most of Florida all the way up to Tampa was overrun by beasts.");
		}
if(Choice==2) {
	System.out.println("'nah, I'm good' you reply. You look over the wastelands, what \r\n"
			+"used to be Brooklyn and Rhoad Island had been ravaged by the beasts, years \r\n"
			+ "before in 1990, right before the wall started being built. In the distance \r\n"
			+ "lay the ruins of the statue of liberty. What was once a monument of the \r\n"
			+ "world now disheveled. ‘Did Adam tell you about Chile?’ Sean asks. ‘yah’ you \r\n"
			+ " reply ‘I can’t believe they’ve this strong in just a year, out of nowhere.\r\n"
			+ " It makes me wonder if we can even beat them’ Sean takes another long drag \r\n"
			+ "finishing it off, flicking it to the ground and scraping it with his boot \r\n"
			+ "‘that’s actually what I wanted to talk to you about’ he turns around and\r\n"
			+ "leans his back against the railing ‘I think I might have found a way to \r\n"
			+ "get rid of the beasts. For good’ you laugh at this and shake your head \r\n"
			+ "‘And I’m sure it will work out just as well as all your other plans and\r\n"
			+ "escapades’ he stands up straight and looks you in the eyes ‘this isn’t like\r\n"
			+ " the others. This is backed up with proof, we’ve been trying to find the \r\n"
			+ "beasts in the wrong place this whole time. They travel by water across the\r\n"
			+ " Atlantic yes, but they don’t come the ocean. But an island that we didn’t\r\n"
			+ " even know existed, Adam has been tracking a several specific beasts for a\r\n"
			+ "few months now, the tracker says that this beast migrates to and from one \r\n"
			+ "exact coordinate and back to the mainland every few weeks. And we know that\r\n"
			+ " the beasts are amphibious but need land to survive. If there is any way to\r\n"
			+ " get rid of them for sure than it’s there. Even Adam believes me this time.\r\n"
			+ " The only problem is that sailing there is suicide, and the military denied\r\n"
			+ " to fund to fly a fleet of ships based on a theory from a couple of wall \r\n"
			+ "mercenaries’ you cut him off before he can go on ‘well that’s that, if we \r\n"
			+ "have no way of getting there than why are we still talking’ he seems \r\n"
			+ "shocked by you saying this but doesn’t stop you when you head to the \r\n"
			+ "elevator to the other side of the wall. A large digital bulletin says where\r\n"
			+ " they need mercenaries on duty, looks like they need you to take the chute to either   ");
	System.out.println("Sean takes a long drag than says ‘Did Adam tell you about Chile?’ \r\n"
			+ "Sean asks. ‘yah’ you reply ‘I can’t believe they’ve this strong in just a year, \r\n"
			+ "out of nowhere. It makes me wonder if we can even beat them’ Sean takes another \r\n"
			+ "long drag finishing it off, flicking it to the ground and scraping it with his \r\n"
			+ "boot ‘that’s actually what I wanted to talk to you about’ he turns around and \r\n"
			+ "leans his back against the railing ‘I think I might have found a way to get \r\n"
			+ "rid of the beasts. For good’ you laugh at this and shake your head ‘And I’m \r\n"
			+ "sure it will work out just as well as all your other plans and escapades’ he \r\n"
			+ "stands up straight and looks you in the eyes ‘this isn’t like the others. This \r\n"
			+ "is backed up with proof, we’ve been trying to find the beasts in the wrong \r\n"
			+ "place this whole time. They travel by water across the Atlantic yes, but they\r\n"
			+ " don’t come the ocean. But an island that we didn’t even know existed, Adam \r\n"
			+ "has been tracking a several specific beasts for a few months now, the tracker \r\n"
			+ "says that this beast migrates to and from one exact coordinate and back to the\r\n"
			+ " mainland every few weeks. And we know that the beasts are amphibious but need\r\n"
			+ " land to survive. If there is any way to get rid of them for sure than it’s\r\n"
			+ " there. Even Adam believes me this time. The only problem is that sailing there\r\n"
			+ " is suicide, and the military denied to fund to fly a fleet of ships based on a \r\n"
			+ "theory from a couple of wall mercenaries’ you cut him off before he can go on \r\n"
			+ "‘well that’s that, if we have no way of getting there than why are we still\r\n"
			+ " talking’ he seems shocked by you saying this but doesn’t stop you when you head\r\n"
			+ " to the elevator to the other side of the wall. A large digital bulletin says \r\n"
			+ "where they need mercenaries on duty, looks like they need you to take the chute \r\n"
			+ "to either.");
		}
System.out.println("Boston(1), or Philledelphia(2)?");
Choice = input.nextInt();
if(Choice==1) {
	System.out.println("You walk over to the chute, a metal pod shot at over three hundred\r\n"
			+ "miles per hour across a tube following the wall. You punch in Boston and jump\r\n"
			+ "the small pod. As soon as your seat belt clicks you feel yourself launch forward\r\n"
			+ "and within a few minutes find yourslef in Boston, you jump out and walk over to \r\n"
			+ "the elevator.");
	System.out.println("Boston, Massachusettes.\r\n" + 
			"November 8th, 2025.\r\n" + 
			"1:46 PM.\r\n" + 
			"Wastelands.\r\n" +
			"Outside the Wall.");
	System.out.println("You've been wondering the wastelands for a few hours and its been oddly\r\n"
			+ "quiet. Too quiet. Suddenly from a crumbling building you see it. But it saw you\r\n"
			+ "first and lunges!");
	System.out.println("                                                                                                                                                                         \r\n" + 
			"                                                                                                            .........                      .                                        \r\n" + 
			"                                                                                                        . . ..... ...         ..                                                    \r\n" + 
			"                                                                                        ....            ,?=......8I,7....                                                           \r\n" + 
			"                                                                     .....              ....         ....,D? ......8?88+......                                                      \r\n" + 
			"                                                                 .....~O7.       .........    ........,I$...Z?..,..ID77$?~7Z87 .....                                                \r\n" + 
			"                                      ....                     ....+O:. ..       .........     .. :......Z+,=?$::=IZZNI7Z7Z$$I7$O=.....   .                                         \r\n" + 
			"                                       ......               ...=$8...                   .... += IN8D7.....~+:8$+7?7Z$ZOO8OZOOZZ7+$7$I...                                            \r\n" + 
			"                      ..       .....   ........         .....+8N.....                     . .+Z8+...,O7IO$$ZZZI$7ODZ7O$8Z7$OOZ88OZZI?$I  ..                                         \r\n" + 
			"                  .  ...........................      .....IZ$..........  .   ....... ..+$:..~+$DD88~.:OO7$$8ZOZ7O7IZOIZ?7$II8OZO$Z88Z$OI. ..         ...                           \r\n" + 
			"                  . .....IZZ$$7$$$7777$ZO=.. . ...  . ...=$N...  ....... ..=7I+.  .  .. :ZZI7...,..ZZZZZD$OO$OZ?$7?$Z+I+$$Z+$?$$ZOZO$ZOZZZ+.....    ....                            \r\n" + 
			"                 ....$O$ZOZZZZ$$77$ZZZZZ$7$7O=.........$$O.....          ..,,8O$Z~ ?I7Z.... ODDDZ778$$O8O8$O$O7ZZ7II7$?+I?+$=+OD8$$O7$ZZ8OOZ$:....  ....                     ..     \r\n" + 
			"             . ....8$$$OOZ$ZZZO8O$77I?7ZO8OZ$$$$.....~ZM:...           ......$II+OI~$OZ$O$+~=ID88O=OOOOO$Z77Z$IO7$$+,O$$+7Z$IOZ77$Z+I+IOOOD8$ZZI.............     .....    .....    \r\n" + 
			"             ..,,O$ZODDO$,,..........,+7$7$Z8OO$ZO.,ZD? .. .         ...  ....?ZZD8ZZ8DI=?Z+=,,,+=?$OOZZOZZOO8888ZZI$$$7IIOO88Z$7O$77ZOZ+8$8887$8OZZO$?:.... ..   .,=:............  \r\n" + 
			"            ...IZZ8N8O:,....        .  ..+7$788O$$$$M..........  .......  ..   ...,IZ8$II$DZ87IIIZZZZOOZ8888Z8ZD8Z$7Z$ZZ$OO$OO$$$I?$OOZDD777OO$=I7?ZOZOIZZO+......I?,.......=7~,..  \r\n" + 
			"            ..8$O8N~.........         .....~7Z8D$IDN?.............,~$OZ+,............,IOZZ$ZZ7ZZZZOZ88888OOOZO$ZZ77?IIOZOOOOOOZOOZZOODD$?$ZZ?ND$Z$7ZO$+Z7OO77$I:?+~:.......II7$+....\r\n" + 
			"         ....O$8NN: ...... ..           .....$O?7DZZZ7  .......... ..~?7DMDZ~.,..:?+,..:I8ZOIZ$7$7$ZO88D88OOZO$7777?I$77$ZZOZZZO$7O8O887$$+ZZ+ZI7$88D77$7OOOM8$$::?~+....?I?IIZ$....\r\n" + 
			"        ....O78NO. ...  .....           .....7+OD8OZOZ+, ........ ....:+$ON8ZZ8OZOO8O$I?~:+++I7$Z$$O888888ZO$$77I77?I7??77O$I7$?I?=+$8Z$$+O7O?=I7?7IDDMMO887$8I+?==Z.==+??I+?+7Z,...\r\n" + 
			"         ..O7ZN8, ....   ...            ...,7?DN8OOZ$ZZ:..........,$I~=I$887III$ZZ$$Z77I$$Z7Z77IZZOO$Z8OOOO$$7II?II??I???$$II7I?==?I8OZ77?I$7II7$I?+$DN8ZOOZ8I?+7+7IDNMZ?+?+++Z+....\r\n" + 
			"         .?7ZDD:......  .....          ...7:IN.7OO88Z$$Z~.....   ....:M?$8ND8D8?~:+Z888D88OO$I$ZZOI$77$ZZZ$$II??????II$II7??+?=+=+?7$N8O+Z$I7$IZI$$OZO888ZZOI?7?+D8NNDDII??I?+=:....\r\n" + 
			"         .ZIOND.....     . ..         ...+~I8..,$ZZ8OZ$$O:,...     . ..=8D8DI,.,,:Z7$7DOOOZ$$OOZ7$777777ZZ$77??+++?II+==?7+?7??$I?77$8DZ+ZI+Z$777$O$7ZOOZZ8$II7888I78I77I???+?:.....\r\n" + 
			"         .77DZ.      ... ..            ==+7I....I$$Z88Z8ZO?,,..  ..... OI,,::+7OZDD8888Z$$ZO8OZ7I77III7777$$7I?+++=~~~~=++?I7$O$IZ$$OODZ+$=7?7$ZZOOZ7$$O$ZZ77ZNDOI7MNOZ?$II++~.. .  \r\n" + 
			"         ,?7D8......      ...       ...=I$D.. ...Z77OOZ$$7Z$:,,....,,...~~~=?$$$DD..8OZ7$$OOO$$7III?77?++77I7I?+?===+?7ZIZ7~~:+Z?I7IZO8I$+O7+OI?$777??I7OI8$Z87D87$N8DZOZ?+?,.      \r\n" + 
			"         :?IO8.......... .. .     ...I+IZ+.. .....OZ7$ZO$7ZZZZ~,............,~~..~=ZOZOZ$$ZZO$7II?I7?++?$Z8OZ$7II?I$OZ$Z$7I??+I~7++I:7$7ZI+Z7+I+?88ZIZ~?$IDZ88NDN$$DZ88$II=....     \r\n" + 
			"         ~?+OO.   ...... ....     ..??$Z+...   ....ZZ$7$ZOOZIOOZI7,.....,,,,,,+Z$ZZ$Z$OOZ$$$$$777$7ZOO$7$$7..Z78Z7I7IO?~~=?~,,+=,I7+?$:7IZ7??O$777IOD$?~,~$D87ZNDDZO77777.....      \r\n" + 
			"        .,7?$O .... ..     ...  ...:?7Z:.      .. ..OO$7ZZ8ZI+I7777$$Z$ZZZZ$$OOZZZOO8OOOOZZ?7777IZOZ$ZOD~?OOZZ$7II?I??I==I=~~=?++IO$7ZI$Z??++Z?+I?777?+~~:=,OO77D888Z7I$......      \r\n" + 
			"          Z=?Z,..    ...    .. ...$I$O~ .      ......ZZ7IZZOO8$?+I7??7$$ZZZ$7$7ZZ8OOO8OZIIIII$$ZOZO$8887OI$IZ$OZZ8O$$77$+++??I7$O8D8OO7O$7I$?7$7I=:~:,~+?+=$=+$7$878Z7$...... .. .  \r\n" + 
			"         .7$=?$...   ...    .. ..O77Z:...        . ...$Z7I7ZOO877$$??+I77O77ZZ$O88O88ODZ?+I77III$88DD8O.Z7I?=7Z8O$$$$7IIIIII7ZOD8D8OOOO7OZ$I77I????++=:~ZI~7=II7I$I8777?=~.... ...  \r\n" + 
			"          .D7~??,. .   .... ,..7II$$=....        . ....~OZIII7$8OOZO88ODDZO888DDD88Z7ZZ77?I7ZZZO888DDO...Z?++7O8DD8OOOZZZZOODNDNND$I+=~?7$DOODDDDDDOZ7?ZIZ?$+7II??IOD?7$II+,....:.. \r\n" + 
			"         ..,II~=?=,....... ..,Z7$7$7.              ......$Z$?II7ZZO88OOOZZOZOO888OI+IZ$IIZ$Z8DDD8DNDD,...Z?==I?8I.. .?OZ$O8O8NNO$Z??II~IOO8OZ$7++II7ZOD8Z$ZO?II,=+7D8O8$??7$,...,...\r\n" + 
			"         ....O$7==+I:.....~$$$7$I7.. .             ........ZOZ7???I$OZZOOZ$$OOZO7~=IZI??ZZ8D8ODNDDND. ...~$+::+7Z~ .....IOON8$7?II7??+IO7??7OZZ7II7$Z$OODOOO=7$:7877+$=~8D$$....+~..\r\n" + 
			"         . ...7?7??++=+???7$$7II?. .                  .......ZOZ$I???III7III7ZO?=?Z8OI7$Z88ZOD88888I......O7=~~?78. .....7ZZ77I?????7ZOI+??+==$$ZZZZZOO88D8D8$=?O$8I=+=..~7+....Z=..\r\n" + 
			"            ....=$?I????IIII?7~. .                          ...:OZ$7II?++??+?I?78I77?7$ZDD$ODO8888O......  O7+?+?OZ....=88OOOO8OO888OOD87$?7I~7ZI~..........8N?$IDZID~~+?,.. ..?Z...\r\n" + 
			"            ... ...~+I7$7I=....  .                          ......?ZZ$777I$O888ZZZD77ZZ88$$DZ$Z888?........ +Z$?+78.....~8NNNNNNDDNN888$7$O$Z$I.   .. .........8$.8+D88+==+?7?7$....\r\n" + 
			"             .. ............ ...                               .  .....:7ND88DNDDDZ?Z8$88$O7.:O88$.. ...    ..7O7?78.. ...........?.?88888?M87.......       ...... IZZ8,,..+~,......\r\n" + 
			"                                                   ... .           ....=OZ?......77OD:....,..I8O7..... .... ...8OII$8~........   ..+7O8O$OO?....  ..         .  ....:+,=,...+....   \r\n" + 
			"                             .. ... .              .....           . .~:........Z$D8........:Z8....         ....8II?=$O.......  ...,OOI88OOOO7,..........       .......:... ....... \r\n" + 
			"                             .. .                  .....           ............OZD,......?7O8Z.....         ....O7~7$~$~......  .:?ZO:.,Z88OOOO8$?=:.  ..       ...... ....  ...... \r\n" + 
			"                              ...  .                  ......           ......7O88.........,.:,..            ...O?+?IO$O+..       ,........,~?OD87++=,...                     .. :...\r\n" + 
			"                               ....                     ...          ......?Z8N$...... .....             .....+:~=+IZ88,.              ........ ,:~...                         ...  \r\n" + 
			"                               ....                     ...        ....:?7IOZ?$.... . ........           ..,$?O,7+~IO88+.              ... ...........                         ...  \r\n" + 
			"                                                                   ....,Z$:...$....  ... .                .....?+,:I$ZDN...                                                         \r\n" + 
			"                                                                       ..........                           ...Z=+?Z+O8OI. ...                                                      \r\n" + 
			"                                                                       ... ......                        ......ZI7Z$?O$N?7....                                                      \r\n" + 
			"                                                                                                       .....:+,,I78+O$ZZN8MZ,......                                                 \r\n" + 
			"                                                                                                       ....O?,..,.?ZZI88DMDD8D~.....                                                \r\n" + 
			"                                                                                                       ............?8?8... .=$OI7~..                                                \r\n" + 
			"                                                                                                            .......$O7OI,... ..D~$+....                                             \r\n" + 
			"                                                                                                                ...?$8Z?? ....... .....                                             \r\n" + 
			"                                                                                                                ...........   .....                                                 \r\n" + 
			"                                                                                                                ..   ....                                                     ");
	if(archetype==1) {
		while(enemy1HP>0) {
		System.out.println("Moves:\r\n"
				+ "Axe(1)\r\n"
				+ "Sword(2)\r\n");
		Choice = input.nextInt();
		if(Choice==1) {
			TheRoll20 = ThreadLocalRandom.current().nextInt(1,20);
			Act1P1 = TheRoll20 + STR;
			if(Act1P1>14) {
				enemy1HP=enemy1HP-Act1P2;
						}
					}
		if(Choice==2) {
			TheRoll20 = ThreadLocalRandom.current().nextInt(1,20);
			Act2P1 = TheRoll20 + STR;
			if(Act2P1>14) {
				enemy1HP=enemy1HP-Act2P2;
			}
		}
				}
			}
	if(archetype==2) {
		while(enemy1HP>0) {
		System.out.println("Moves:\r\n"
				+ "Axe(1)\r\n"
				+ "Sword(2)\r\n");
		Choice = input.nextInt();
		if(Choice==1) {
			TheRoll20 = ThreadLocalRandom.current().nextInt(1,20);
			Act1P1 = TheRoll20 + STR;
			if(Act1P1>14) {
				enemy1HP=enemy1HP-Act1P2;
			}
			}
		}
}