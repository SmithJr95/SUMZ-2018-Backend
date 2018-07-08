package dhbw.ka.mwi.businesshorizon2.businesshorizon2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.dhbw.ka.mwi.businesshorizon2.businesslogic.services.CompanyValuationService;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.ApvCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.CompanyValueDistributionDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FcfCompanyValuationResultDto;
import edu.dhbw.ka.mwi.businesshorizon2.models.dtos.FteCompanyValuationResultDto;


public class CompanyValuationServiceTests {
	
	private List<Double> getLargeCompanyValuesRange(){
		
		List<Double> expectedCompanyValues = new ArrayList<>();
	
		expectedCompanyValues.add(426569.7189863585);
		expectedCompanyValues.add(-500530.092882812);
		expectedCompanyValues.add(134569.1707866462);
		expectedCompanyValues.add(-865691.8940570009);
		expectedCompanyValues.add(858215.8512439469);
		expectedCompanyValues.add(87726.00633534882);
		expectedCompanyValues.add(668690.2794388889);
		expectedCompanyValues.add(148154.44461971684);
		expectedCompanyValues.add(-366471.47146589274);
		expectedCompanyValues.add(871628.4308812732);
		expectedCompanyValues.add(-716304.4243421466);
		expectedCompanyValues.add(78862.76282364153);
		expectedCompanyValues.add(-339271.1612742507);
		expectedCompanyValues.add(175554.72542788298);
		expectedCompanyValues.add(-300362.9632850897);
		expectedCompanyValues.add(199856.8139148315);
		expectedCompanyValues.add(-40372.25884549646);
		expectedCompanyValues.add(-230869.0016575734);
		expectedCompanyValues.add(-623972.412290737);
		expectedCompanyValues.add(-555981.8433425217);
		expectedCompanyValues.add(-404772.9051197275);
		expectedCompanyValues.add(789431.2341121819);
		expectedCompanyValues.add(48634.65983642521);
		expectedCompanyValues.add(-166556.1406472691);
		expectedCompanyValues.add(-143765.93352123862);
		expectedCompanyValues.add(356591.7310662328);
		expectedCompanyValues.add(216417.39187869197);
		expectedCompanyValues.add(-957531.8855852002);
		expectedCompanyValues.add(583578.6738199764);
		expectedCompanyValues.add(-51425.29734536039);
		expectedCompanyValues.add(-237981.44528062455);
		expectedCompanyValues.add(883316.7208178744);
		expectedCompanyValues.add(313791.0813181803);
		expectedCompanyValues.add(376207.35238657845);
		expectedCompanyValues.add(305237.0594677625);
		expectedCompanyValues.add(185401.5178992073);
		expectedCompanyValues.add(-525640.2695357304);
		expectedCompanyValues.add(287511.6078358372);
		expectedCompanyValues.add(-882576.840737346);
		expectedCompanyValues.add(-466595.2953390671);
		expectedCompanyValues.add(-747042.5096135244);
		expectedCompanyValues.add(-469267.8781634412);
		expectedCompanyValues.add(-534246.4198031276);
		expectedCompanyValues.add(-364058.0887036442);
		expectedCompanyValues.add(-40311.10101528838);
		expectedCompanyValues.add(-581640.6758151844);
		expectedCompanyValues.add(109860.29166609189);
		expectedCompanyValues.add(715734.4308841154);
		expectedCompanyValues.add(-288722.823756836);
		expectedCompanyValues.add(959835.927076028);
		expectedCompanyValues.add(-660698.9764743787);
		expectedCompanyValues.add(-756138.2880235295);
		expectedCompanyValues.add(-911625.6876109203);
		expectedCompanyValues.add(-531475.0287969306);
		expectedCompanyValues.add(418876.4568890899);
		expectedCompanyValues.add(584804.729330345);
		expectedCompanyValues.add(51944.56209793687);
		expectedCompanyValues.add(-401090.7297714101);
		expectedCompanyValues.add(-400186.36213667656);
		expectedCompanyValues.add(-324366.69698772964);
		expectedCompanyValues.add(-148063.03057654737);
		expectedCompanyValues.add(832881.6180886119);
		expectedCompanyValues.add(958351.7911115654);
		expectedCompanyValues.add(731829.2988423144);
		expectedCompanyValues.add(921226.6429969843);
		expectedCompanyValues.add(-290623.46139206085);
		expectedCompanyValues.add(239281.34936135216);
		expectedCompanyValues.add(-846120.706675472);
		expectedCompanyValues.add(-179927.23828711337);
		expectedCompanyValues.add(-320515.4192301831);
		expectedCompanyValues.add(610503.2123001742);
		expectedCompanyValues.add(302910.61112182727);
		expectedCompanyValues.add(181104.8961068152);
		expectedCompanyValues.add(369580.92421730957);
		expectedCompanyValues.add(775690.9771736311);
		expectedCompanyValues.add(620285.1328877416);
		expectedCompanyValues.add(302115.004674684);
		expectedCompanyValues.add(-752109.50609532);
		expectedCompanyValues.add(245653.99480548967);
		expectedCompanyValues.add(685206.4921101772);
		expectedCompanyValues.add(-456300.27798243146);
		expectedCompanyValues.add(215302.96314722952);
		expectedCompanyValues.add(-264984.8813846669);
		expectedCompanyValues.add(-763964.3016441191);
		expectedCompanyValues.add(-988939.1866950442);
		expectedCompanyValues.add(-520859.1355249261);
		expectedCompanyValues.add(629332.6192151578);
		expectedCompanyValues.add(-74847.45030441892);
		expectedCompanyValues.add(-865960.6686196737);
		expectedCompanyValues.add(-781024.6709015538);
		expectedCompanyValues.add(258811.26114688138);
		expectedCompanyValues.add(633839.0514418555);
		expectedCompanyValues.add(-293276.639912426);
		expectedCompanyValues.add(16473.87741641351);
		expectedCompanyValues.add(-681736.959117097);
		expectedCompanyValues.add(542802.9087485366);
		expectedCompanyValues.add(707735.6840969461);
		expectedCompanyValues.add(-203343.44749020762);
		expectedCompanyValues.add(188994.1027934393);
		expectedCompanyValues.add(835599.5665559513);
		expectedCompanyValues.add(794572.4471553785);
		expectedCompanyValues.add(115825.57876701956);
		expectedCompanyValues.add(146809.3624688557);
		expectedCompanyValues.add(906351.245099396);
		expectedCompanyValues.add(750130.6321733042);
		expectedCompanyValues.add(31826.016395792365);
		expectedCompanyValues.add(-518657.15183456417);
		expectedCompanyValues.add(-750197.010713056);
		expectedCompanyValues.add(-643173.512064816);
		expectedCompanyValues.add(-494815.837925894);
		expectedCompanyValues.add(-594563.4080249176);
		expectedCompanyValues.add(830895.4586275292);
		expectedCompanyValues.add(-816525.9759117274);
		expectedCompanyValues.add(305062.46824010764);
		expectedCompanyValues.add(299306.6554054122);
		expectedCompanyValues.add(662675.8159462437);
		expectedCompanyValues.add(-407642.6977736738);
		expectedCompanyValues.add(731858.7070581077);
		expectedCompanyValues.add(-687248.8280336399);
		expectedCompanyValues.add(565507.5151403723);
		expectedCompanyValues.add(-91303.71896060137);
		expectedCompanyValues.add(-881330.721781866);
		expectedCompanyValues.add(-360329.8944651374);
		expectedCompanyValues.add(637181.6302645786);
		expectedCompanyValues.add(-858028.4797011319);
		expectedCompanyValues.add(36726.140975749586);
		expectedCompanyValues.add(-117317.50047591969);
		expectedCompanyValues.add(832671.871717544);
		expectedCompanyValues.add(-91661.20265815186);
		expectedCompanyValues.add(405308.0721472334);
		expectedCompanyValues.add(841642.0334391284);
		expectedCompanyValues.add(-766083.0188233367);
		expectedCompanyValues.add(-724369.86592834);
		expectedCompanyValues.add(294517.51836383436);
		expectedCompanyValues.add(788368.8991059121);
		expectedCompanyValues.add(84154.29832038353);
		expectedCompanyValues.add(137203.52795217652);
		expectedCompanyValues.add(-890295.9858585984);
		expectedCompanyValues.add(830929.0406210569);
		expectedCompanyValues.add(467968.8864404054);
		expectedCompanyValues.add(-581830.9180144612);
		expectedCompanyValues.add(59207.553516927874);
		expectedCompanyValues.add(-675689.8529723899);
		expectedCompanyValues.add(-362636.0708031886);
		expectedCompanyValues.add(-72714.8399030288);
		expectedCompanyValues.add(332484.3524676943);
		expectedCompanyValues.add(450357.43129283166);
		expectedCompanyValues.add(-584202.8430263014);
		expectedCompanyValues.add(990083.3444050148);
		expectedCompanyValues.add(-746431.5433225688);
		expectedCompanyValues.add(-931651.0482428402);
		expectedCompanyValues.add(-143728.82355427218);
		expectedCompanyValues.add(-866452.3954930461);
		expectedCompanyValues.add(-174786.03448279563);
		expectedCompanyValues.add(-271394.7355342832);
		expectedCompanyValues.add(-613796.8054783194);
		expectedCompanyValues.add(39936.914623090765);
		expectedCompanyValues.add(541952.052994703);
		expectedCompanyValues.add(345044.2486968648);
		expectedCompanyValues.add(-959056.6591069478);
		expectedCompanyValues.add(747108.3373470465);
		expectedCompanyValues.add(125689.11905656615);
		expectedCompanyValues.add(438607.2354270059);
		expectedCompanyValues.add(69448.50224099075);
		expectedCompanyValues.add(644961.4650292704);
		expectedCompanyValues.add(-74638.74986711773);
		expectedCompanyValues.add(91998.34111453709);
		expectedCompanyValues.add(-810238.4787809029);
		expectedCompanyValues.add(-797608.2229999842);
		expectedCompanyValues.add(-877447.260460898);
		expectedCompanyValues.add(797194.8690254521);
		expectedCompanyValues.add(78585.0525522246);
		expectedCompanyValues.add(-443594.3586182769);
		expectedCompanyValues.add(597874.72927595);
		expectedCompanyValues.add(-769298.9411762179);
		expectedCompanyValues.add(-701619.9246559094);
		expectedCompanyValues.add(104815.3907069792);
		expectedCompanyValues.add(338293.4726240323);
		expectedCompanyValues.add(-342465.0979327535);
		expectedCompanyValues.add(-202940.0081121024);
		expectedCompanyValues.add(-933801.6439133703);
		expectedCompanyValues.add(603485.8211015463);
		expectedCompanyValues.add(143452.2659199622);
		expectedCompanyValues.add(-640507.9587035527);
		expectedCompanyValues.add(-394429.7334346514);
		expectedCompanyValues.add(719691.0717236458);
		expectedCompanyValues.add(45927.48787763808);
		expectedCompanyValues.add(946657.3482277573);
		expectedCompanyValues.add(-428512.59752193594);
		expectedCompanyValues.add(-667580.0667895982);
		expectedCompanyValues.add(-642072.9336364351);
		expectedCompanyValues.add(727462.9487623356);
		expectedCompanyValues.add(150059.11573059764);
		expectedCompanyValues.add(224770.34102336084);
		expectedCompanyValues.add(394527.56226625224);
		expectedCompanyValues.add(-210160.9726663354);
		expectedCompanyValues.add(-186382.86646953283);
		expectedCompanyValues.add(395991.23726316565);
		expectedCompanyValues.add(-959056.0192648848);
		expectedCompanyValues.add(-988105.285092395);
		expectedCompanyValues.add(-173446.30635782995);
		expectedCompanyValues.add(-4673.270862452569);
		expectedCompanyValues.add(321551.793712748);
		expectedCompanyValues.add(-619452.1023136728);
		expectedCompanyValues.add(-731893.3090901584);
		expectedCompanyValues.add(919062.1627476157);
		expectedCompanyValues.add(-596999.4825408364);
		expectedCompanyValues.add(164183.26266467432);
		expectedCompanyValues.add(-958365.2607696385);
		expectedCompanyValues.add(404085.48492165026);
		expectedCompanyValues.add(310532.7135750111);
		expectedCompanyValues.add(777535.1755303056);
		expectedCompanyValues.add(-337807.963942599);
		expectedCompanyValues.add(-210832.14895932784);
		expectedCompanyValues.add(615137.4698039342);
		expectedCompanyValues.add(921131.450767322);
		expectedCompanyValues.add(748976.6742442364);
		expectedCompanyValues.add(765556.9500628402);
		expectedCompanyValues.add(-859816.0756485173);
		expectedCompanyValues.add(-365725.22408087796);
		expectedCompanyValues.add(-903506.2092475499);
		expectedCompanyValues.add(-98631.55386405252);
		expectedCompanyValues.add(-660305.0536561474);
		expectedCompanyValues.add(-730319.6870239575);
		expectedCompanyValues.add(958039.0440703237);
		expectedCompanyValues.add(999651.106963797);
		expectedCompanyValues.add(-583562.3609268917);
		expectedCompanyValues.add(-920473.1141296234);
		expectedCompanyValues.add(747373.4980982919);
		expectedCompanyValues.add(-62108.907420810545);
		expectedCompanyValues.add(-523477.62483763316);
		expectedCompanyValues.add(-903178.9846592215);
		expectedCompanyValues.add(749228.3577924618);
		expectedCompanyValues.add(37113.01776868582);
		expectedCompanyValues.add(58217.86871122592);
		expectedCompanyValues.add(302613.79805172957);
		expectedCompanyValues.add(626540.9521278711);
		expectedCompanyValues.add(-278375.55752345524);
		expectedCompanyValues.add(-773794.5850235197);
		expectedCompanyValues.add(-311250.14160856046);
		expectedCompanyValues.add(-477908.33188739204);
		expectedCompanyValues.add(255842.16873781243);
		expectedCompanyValues.add(-911488.6399569362);
		expectedCompanyValues.add(757470.0375902373);
		expectedCompanyValues.add(-625524.9569398197);
		expectedCompanyValues.add(-317471.39989955525);
		expectedCompanyValues.add(-928128.4484755914);
		expectedCompanyValues.add(-756671.132786534);
		expectedCompanyValues.add(-296894.85344836686);
		expectedCompanyValues.add(-262841.9438254101);
		expectedCompanyValues.add(582298.8110996205);
		expectedCompanyValues.add(399528.97105971375);
		expectedCompanyValues.add(-435779.4571132829);
		expectedCompanyValues.add(-523977.9606406596);
		expectedCompanyValues.add(-218862.4044801573);
		expectedCompanyValues.add(59914.81783949048);
		expectedCompanyValues.add(-360380.36470015685);
		expectedCompanyValues.add(631074.7449892364);
		expectedCompanyValues.add(122909.01798056881);
		expectedCompanyValues.add(869509.6140698176);
		expectedCompanyValues.add(492123.2038132127);
		expectedCompanyValues.add(-707590.8173846921);
		expectedCompanyValues.add(29761.14363629697);
		expectedCompanyValues.add(-429381.248823961);
		expectedCompanyValues.add(-93473.85198581335);
		expectedCompanyValues.add(419646.5125854274);
		expectedCompanyValues.add(-381641.44533324556);
		expectedCompanyValues.add(-961835.2612732286);
		expectedCompanyValues.add(932066.1753812071);
		expectedCompanyValues.add(-103590.01759934518);
		expectedCompanyValues.add(-251441.27291330067);
		expectedCompanyValues.add(-122941.37081877294);
		expectedCompanyValues.add(752203.494646989);
		expectedCompanyValues.add(-632552.6759445232);
		expectedCompanyValues.add(829238.8200510717);
		expectedCompanyValues.add(826053.6546627055);
		expectedCompanyValues.add(829769.6210563749);
		expectedCompanyValues.add(-64145.23761612398);
		expectedCompanyValues.add(-204847.0970231992);
		expectedCompanyValues.add(956667.7358553524);
		expectedCompanyValues.add(910310.8088880747);
		expectedCompanyValues.add(-51753.256891411846);
		expectedCompanyValues.add(-540286.0372108843);
		expectedCompanyValues.add(-287598.2963233135);
		expectedCompanyValues.add(-586283.7430138935);
		expectedCompanyValues.add(-441393.2530791422);
		expectedCompanyValues.add(-947888.5846710858);
		expectedCompanyValues.add(-797378.9245710034);
		expectedCompanyValues.add(503986.81057840795);
		expectedCompanyValues.add(536944.3541655045);
		expectedCompanyValues.add(163191.23506833124);
		expectedCompanyValues.add(847109.4989577171);
		expectedCompanyValues.add(-300734.21850197366);
		expectedCompanyValues.add(-123225.61184773815);
		expectedCompanyValues.add(553039.5037628242);
		expectedCompanyValues.add(-538557.1379511494);
		expectedCompanyValues.add(-730980.5391543707);
		expectedCompanyValues.add(155825.79178240965);
		expectedCompanyValues.add(-685772.7588064211);
		expectedCompanyValues.add(179973.81482231757);
		expectedCompanyValues.add(-137480.25914978946);
		expectedCompanyValues.add(317276.2925120245);
		expectedCompanyValues.add(738190.0811546242);
		expectedCompanyValues.add(-767643.4364156681);
		expectedCompanyValues.add(-177452.67922102776);
		expectedCompanyValues.add(-435797.7110753603);
		expectedCompanyValues.add(898231.1999541549);
		expectedCompanyValues.add(521182.9046172318);
		expectedCompanyValues.add(460500.23193846224);
		expectedCompanyValues.add(397821.2281369264);
		expectedCompanyValues.add(441151.8002778825);
		expectedCompanyValues.add(192441.025988888);
		expectedCompanyValues.add(203856.01807419746);
		expectedCompanyValues.add(480496.73594492977);
		expectedCompanyValues.add(-629470.5831729069);
		expectedCompanyValues.add(947148.853074448);
		expectedCompanyValues.add(974204.5984190186);
		expectedCompanyValues.add(967365.761722431);
		expectedCompanyValues.add(708179.6264397588);
		expectedCompanyValues.add(711654.811391304);
		expectedCompanyValues.add(413831.41558809625);
		expectedCompanyValues.add(-774161.6444981514);
		expectedCompanyValues.add(-163647.81071008986);
		expectedCompanyValues.add(465739.2788330768);
		expectedCompanyValues.add(-348901.7456466572);
		expectedCompanyValues.add(450111.60398339666);
		expectedCompanyValues.add(-948271.0357033983);
		expectedCompanyValues.add(-478209.22866637196);
		expectedCompanyValues.add(179633.3183668675);
		expectedCompanyValues.add(-421771.29784891545);
		expectedCompanyValues.add(403305.86608265946);
		expectedCompanyValues.add(-645029.0810905262);
		expectedCompanyValues.add(-876391.0309748884);
		expectedCompanyValues.add(132106.09143336467);
		expectedCompanyValues.add(239756.68926294264);
		expectedCompanyValues.add(-796575.7152679394);
		expectedCompanyValues.add(-328849.5660805848);
		expectedCompanyValues.add(126341.52397890971);
		expectedCompanyValues.add(57893.325151547324);
		expectedCompanyValues.add(89227.75355685526);
		expectedCompanyValues.add(780184.1360884416);
		expectedCompanyValues.add(-970493.144539087);
		expectedCompanyValues.add(222351.07047157176);
		expectedCompanyValues.add(654916.8988553542);
		expectedCompanyValues.add(-604198.9965548415);
		expectedCompanyValues.add(-87981.0285069329);
		expectedCompanyValues.add(-82355.73508937424);
		expectedCompanyValues.add(267065.7711621183);
		expectedCompanyValues.add(-634525.5349944069);
		expectedCompanyValues.add(-622425.0144147153);
		expectedCompanyValues.add(297253.41415797477);
		expectedCompanyValues.add(207538.04293784825);
		expectedCompanyValues.add(-1760.136509123724);
		expectedCompanyValues.add(650526.2292044125);
		expectedCompanyValues.add(210418.7374665856);
		expectedCompanyValues.add(454667.5829640804);
		expectedCompanyValues.add(-213794.18835170765);
		expectedCompanyValues.add(279457.42494539544);
		expectedCompanyValues.add(-884166.0938348701);
		expectedCompanyValues.add(-449232.3296912209);
		expectedCompanyValues.add(-808464.1657944531);
		expectedCompanyValues.add(317628.02369003254);
		expectedCompanyValues.add(-167554.39843476564);
		expectedCompanyValues.add(359008.37629323965);
		expectedCompanyValues.add(599302.1836895561);
		expectedCompanyValues.add(-446177.5272292446);
		expectedCompanyValues.add(631083.7224827241);
		expectedCompanyValues.add(-868158.1122926185);
		expectedCompanyValues.add(-453619.0463730787);
		expectedCompanyValues.add(-607451.6763880521);
		expectedCompanyValues.add(-163340.60158951732);
		expectedCompanyValues.add(-755203.0027374406);
		expectedCompanyValues.add(-841177.8706015225);
		expectedCompanyValues.add(320409.8918476312);
		expectedCompanyValues.add(589186.6762783343);
		expectedCompanyValues.add(193604.20414799498);
		expectedCompanyValues.add(-635105.4548020456);
		expectedCompanyValues.add(-454123.09100045497);
		expectedCompanyValues.add(702896.9853877171);
		expectedCompanyValues.add(-990746.8401289464);
		expectedCompanyValues.add(-101728.88666880911);
		expectedCompanyValues.add(-637441.204625593);
		expectedCompanyValues.add(666232.1276079223);
		expectedCompanyValues.add(-885274.7522337552);
		expectedCompanyValues.add(-634415.2742683948);
		expectedCompanyValues.add(-938516.0386429332);
		expectedCompanyValues.add(-258482.46484948392);
		expectedCompanyValues.add(828784.7363624554);
		expectedCompanyValues.add(-275147.53994050727);
		expectedCompanyValues.add(805775.7797949456);
		expectedCompanyValues.add(-148367.91846351896);
		expectedCompanyValues.add(216352.5846327087);
		expectedCompanyValues.add(406029.1638303944);
		expectedCompanyValues.add(-218493.03714807844);
		expectedCompanyValues.add(-517992.5413800035);
		expectedCompanyValues.add(791626.6175390629);
		expectedCompanyValues.add(-997780.9030986873);
		expectedCompanyValues.add(-848595.0568156894);
		expectedCompanyValues.add(-820195.0093822721);
		expectedCompanyValues.add(-300745.573261713);
		expectedCompanyValues.add(-30161.395049938816);
		expectedCompanyValues.add(863470.415395203);
		expectedCompanyValues.add(398133.5464313708);
		expectedCompanyValues.add(430503.9504836318);
		expectedCompanyValues.add(-901711.0102811008);
		expectedCompanyValues.add(204463.7011882814);
		expectedCompanyValues.add(411688.54671374755);
		expectedCompanyValues.add(-124481.65840294422);
		expectedCompanyValues.add(-355535.28020603035);
		expectedCompanyValues.add(-861397.5854495575);
		expectedCompanyValues.add(-178793.8295009397);
		expectedCompanyValues.add(569382.5387904332);
		expectedCompanyValues.add(-25313.631361541688);
		expectedCompanyValues.add(934705.6079573501);
		expectedCompanyValues.add(-232355.7983791005);
		expectedCompanyValues.add(-641131.4728466022);
		expectedCompanyValues.add(316415.4495008993);
		expectedCompanyValues.add(360409.8854830123);
		expectedCompanyValues.add(-606984.5322940855);
		expectedCompanyValues.add(-601631.5472008749);
		expectedCompanyValues.add(-205628.49635333812);
		expectedCompanyValues.add(-190026.60627794452);
		expectedCompanyValues.add(313315.5673724429);
		expectedCompanyValues.add(-622336.386194624);
		expectedCompanyValues.add(310439.7768418966);
		expectedCompanyValues.add(132574.9512642708);
		expectedCompanyValues.add(-89997.13107147196);
		expectedCompanyValues.add(190819.64983371925);
		expectedCompanyValues.add(-975978.5601578532);
		expectedCompanyValues.add(-359095.27714863536);
		expectedCompanyValues.add(-899996.4004030356);
		expectedCompanyValues.add(874637.6184579947);
		expectedCompanyValues.add(199245.1713946329);
		expectedCompanyValues.add(-194764.55226306745);
		expectedCompanyValues.add(910230.6122821346);
		expectedCompanyValues.add(576731.9350623514);
		expectedCompanyValues.add(7724.318186973105);
		expectedCompanyValues.add(-523947.5017670261);
		expectedCompanyValues.add(-338879.0616795174);
		expectedCompanyValues.add(-442553.37663407903);
		expectedCompanyValues.add(510309.1759749451);
		expectedCompanyValues.add(-871288.674901153);
		expectedCompanyValues.add(854711.2312680497);
		expectedCompanyValues.add(-213538.1605372813);
		expectedCompanyValues.add(-511450.4425742874);
		expectedCompanyValues.add(586483.3930089632);
		expectedCompanyValues.add(966287.609236738);
		expectedCompanyValues.add(564083.5513595666);
		expectedCompanyValues.add(-943651.1557699965);
		expectedCompanyValues.add(-46259.975082519464);
		expectedCompanyValues.add(254660.32725938712);
		expectedCompanyValues.add(778849.1478402489);
		expectedCompanyValues.add(54556.35910435673);
		expectedCompanyValues.add(78915.76495342818);
		expectedCompanyValues.add(434631.01117650187);
		expectedCompanyValues.add(907223.7145222367);
		expectedCompanyValues.add(-883990.6672399936);
		expectedCompanyValues.add(-232716.87592474977);
		expectedCompanyValues.add(596234.3636882824);
		expectedCompanyValues.add(667800.8636223176);
		expectedCompanyValues.add(985803.6309205892);
		expectedCompanyValues.add(176460.50041507673);
		expectedCompanyValues.add(-891147.4432868052);
		expectedCompanyValues.add(361563.3738017939);
		expectedCompanyValues.add(191335.2533647227);
		expectedCompanyValues.add(352966.93202664563);
		expectedCompanyValues.add(414316.53805061453);
		expectedCompanyValues.add(-638600.0158744904);
		expectedCompanyValues.add(-521077.0292262585);
		expectedCompanyValues.add(-293973.17772008444);
		expectedCompanyValues.add(-408376.8683235822);
		expectedCompanyValues.add(-41785.968671977054);
		expectedCompanyValues.add(-431413.836712413);
		expectedCompanyValues.add(-634780.9502547672);
		expectedCompanyValues.add(366912.9906320891);
		expectedCompanyValues.add(827601.2753505956);
		expectedCompanyValues.add(-274182.1485505422);
		expectedCompanyValues.add(831455.5210922521);
		expectedCompanyValues.add(-154129.49953008525);
		expectedCompanyValues.add(-249785.02395878488);
		expectedCompanyValues.add(-591040.0966382101);
		expectedCompanyValues.add(-893836.0209271779);
		expectedCompanyValues.add(-338278.50289915083);
		expectedCompanyValues.add(-99424.14461970702);
		expectedCompanyValues.add(-176948.97916357324);
		expectedCompanyValues.add(571442.3739460378);
		expectedCompanyValues.add(460520.56964582624);
		expectedCompanyValues.add(13226.3722694756);
		expectedCompanyValues.add(595785.2066345627);
		expectedCompanyValues.add(-705660.0154360082);
		expectedCompanyValues.add(686436.1406668595);
		expectedCompanyValues.add(41768.489068018156);
		expectedCompanyValues.add(988483.3917206491);
		expectedCompanyValues.add(-858685.8940233544);
		expectedCompanyValues.add(-516744.5868856666);
		expectedCompanyValues.add(545465.5459707272);
		expectedCompanyValues.add(-935253.2341665509);
		expectedCompanyValues.add(-885700.5528279362);
		expectedCompanyValues.add(-805650.7384129672);
		expectedCompanyValues.add(-30271.41647116281);
		expectedCompanyValues.add(61725.76550234319);
		expectedCompanyValues.add(-342280.9220801806);
		expectedCompanyValues.add(-578149.8050420253);
		expectedCompanyValues.add(-769051.0778103124);
		expectedCompanyValues.add(843704.7931983743);
		expectedCompanyValues.add(336156.148666098);
		expectedCompanyValues.add(-103185.77558016835);
		expectedCompanyValues.add(-427221.376791953);
		expectedCompanyValues.add(764967.1258169636);
		expectedCompanyValues.add(245296.11255034036);
		expectedCompanyValues.add(-484348.03226446465);
		expectedCompanyValues.add(-469897.8358623376);
		expectedCompanyValues.add(528672.2163398231);
		expectedCompanyValues.add(-205859.45106672996);
		expectedCompanyValues.add(-185869.5054765857);
		expectedCompanyValues.add(18581.793997811037);
		expectedCompanyValues.add(-299259.1684957318);
		expectedCompanyValues.add(84382.64508934226);
		expectedCompanyValues.add(878762.3481343449);
		expectedCompanyValues.add(-938198.8686417923);
		expectedCompanyValues.add(422511.0817109344);
		expectedCompanyValues.add(13227.076201485703);
		expectedCompanyValues.add(236414.72811382473);
		expectedCompanyValues.add(-525328.5824098011);
		expectedCompanyValues.add(-436807.6295989009);
		expectedCompanyValues.add(-561173.9574735048);
		expectedCompanyValues.add(616486.8541407855);
		expectedCompanyValues.add(-59094.58237504354);
		expectedCompanyValues.add(62911.681882862);
		expectedCompanyValues.add(-727105.3139483108);
		expectedCompanyValues.add(646019.084255235);
		expectedCompanyValues.add(354005.00351949595);
		expectedCompanyValues.add(539410.1971169161);
		expectedCompanyValues.add(202959.560068056);
		expectedCompanyValues.add(-483386.5728715112);
		expectedCompanyValues.add(35348.442040336435);
		expectedCompanyValues.add(366216.02291468624);
		expectedCompanyValues.add(897083.979097825);
		expectedCompanyValues.add(453060.3587906149);
		expectedCompanyValues.add(499605.13775077695);
		expectedCompanyValues.add(-622617.4734937991);
		expectedCompanyValues.add(6805.960093136062);
		expectedCompanyValues.add(417082.49090034864);
		expectedCompanyValues.add(806844.8556036707);
		expectedCompanyValues.add(-886351.2841264498);
		expectedCompanyValues.add(59413.071977062384);
		expectedCompanyValues.add(895621.6701254719);
		expectedCompanyValues.add(-777650.1486451597);
		expectedCompanyValues.add(97142.99180476042);
		expectedCompanyValues.add(-581428.620583724);
		expectedCompanyValues.add(851610.9965780219);
		expectedCompanyValues.add(-100720.77818377351);
		expectedCompanyValues.add(-993482.361046788);
		expectedCompanyValues.add(892714.6025574079);
		expectedCompanyValues.add(-43810.31407456496);
		expectedCompanyValues.add(-394025.3863793084);
		expectedCompanyValues.add(821666.8321499934);
		expectedCompanyValues.add(283491.17383765243);
		expectedCompanyValues.add(74833.3567180105);
		expectedCompanyValues.add(-861162.5064490729);
		expectedCompanyValues.add(16946.60488049162);
		expectedCompanyValues.add(-808043.2356401046);
		expectedCompanyValues.add(-354110.5366329707);
		expectedCompanyValues.add(993349.1444886341);
		expectedCompanyValues.add(-295919.19842579006);
		expectedCompanyValues.add(-261908.49702925712);
		expectedCompanyValues.add(-931478.8337949689);
		expectedCompanyValues.add(-890055.6344142177);
		expectedCompanyValues.add(260702.9314007687);
		expectedCompanyValues.add(499610.4679804146);
		expectedCompanyValues.add(-491919.8248755263);
		expectedCompanyValues.add(68091.02674238128);
		expectedCompanyValues.add(-572251.01426829);
		expectedCompanyValues.add(938927.9521950972);
		expectedCompanyValues.add(630444.6878075683);
		expectedCompanyValues.add(-28931.393825966516);
		expectedCompanyValues.add(118682.313444786);
		expectedCompanyValues.add(-137474.63940440735);
		expectedCompanyValues.add(692872.7655517347);
		expectedCompanyValues.add(-554421.6855345443);
		expectedCompanyValues.add(255797.19690807047);
		expectedCompanyValues.add(44864.403381080134);
		expectedCompanyValues.add(-852561.4189083886);
		expectedCompanyValues.add(674459.2831373017);
		expectedCompanyValues.add(833613.1646110148);
		expectedCompanyValues.add(49376.96525056497);
		expectedCompanyValues.add(-545865.9539609583);
		expectedCompanyValues.add(-812575.1383638592);
		expectedCompanyValues.add(106638.08886885992);
		expectedCompanyValues.add(-508045.6993995837);
		expectedCompanyValues.add(154233.7945950213);
		expectedCompanyValues.add(-746125.0568487503);
		expectedCompanyValues.add(-691456.651893523);
		expectedCompanyValues.add(-482251.98626024526);
		expectedCompanyValues.add(-579462.3369445107);
		expectedCompanyValues.add(-846520.7588370931);
		expectedCompanyValues.add(632060.0942299061);
		expectedCompanyValues.add(99987.20954502397);
		expectedCompanyValues.add(279619.12813864974);
		expectedCompanyValues.add(-655631.4445980848);
		expectedCompanyValues.add(-666328.3415046211);
		expectedCompanyValues.add(-80094.46557607315);
		expectedCompanyValues.add(492226.1945371919);
		expectedCompanyValues.add(605411.0229380641);
		expectedCompanyValues.add(774442.0129819564);
		expectedCompanyValues.add(-950237.2576378408);
		expectedCompanyValues.add(681493.8636360185);
		expectedCompanyValues.add(598190.621008937);
		expectedCompanyValues.add(-31913.547142192256);
		expectedCompanyValues.add(-563662.8288740184);
		expectedCompanyValues.add(714645.5680918361);
		expectedCompanyValues.add(-24053.392585095018);
		expectedCompanyValues.add(-220343.68985163735);
		expectedCompanyValues.add(-729845.7153076439);
		expectedCompanyValues.add(-427625.13303045323);
		expectedCompanyValues.add(-839127.1131352002);
		expectedCompanyValues.add(302974.13543455256);
		expectedCompanyValues.add(726108.5477684953);
		expectedCompanyValues.add(-18884.941698701587);
		expectedCompanyValues.add(217816.46103630192);
		expectedCompanyValues.add(142223.38334231032);
		expectedCompanyValues.add(274025.8334145732);
		expectedCompanyValues.add(-63079.88936189178);
		expectedCompanyValues.add(871555.3782107038);
		expectedCompanyValues.add(332859.6410405638);
		expectedCompanyValues.add(783104.5141455473);
		expectedCompanyValues.add(915695.1443779396);
		expectedCompanyValues.add(-353522.8429859312);
		expectedCompanyValues.add(-540721.0209662849);
		expectedCompanyValues.add(982063.4729141905);
		expectedCompanyValues.add(-956968.5912037133);
		expectedCompanyValues.add(351618.7564645142);
		expectedCompanyValues.add(161441.7256312361);
		expectedCompanyValues.add(487216.7580440873);
		expectedCompanyValues.add(787915.5764854096);
		expectedCompanyValues.add(690670.291304481);
		expectedCompanyValues.add(669918.1060770706);
		expectedCompanyValues.add(-426415.6635577275);
		expectedCompanyValues.add(848098.6869191455);
		expectedCompanyValues.add(-354314.70223332325);
		expectedCompanyValues.add(268585.82025164366);
		expectedCompanyValues.add(139539.85914816498);
		expectedCompanyValues.add(810926.5429271816);
		expectedCompanyValues.add(-535119.3210985428);
		expectedCompanyValues.add(656477.0143627638);
		expectedCompanyValues.add(-96614.12321723171);
		expectedCompanyValues.add(901948.2349861788);
		expectedCompanyValues.add(579050.2454398186);
		expectedCompanyValues.add(65036.01995652821);
		expectedCompanyValues.add(-229360.88069253718);
		expectedCompanyValues.add(-325365.0860153731);
		expectedCompanyValues.add(-422243.3695503054);
		expectedCompanyValues.add(-315683.69597892626);
		expectedCompanyValues.add(523697.4136275505);
		expectedCompanyValues.add(-151942.18223878962);
		expectedCompanyValues.add(-504393.6599103971);
		expectedCompanyValues.add(461409.72389039374);
		expectedCompanyValues.add(-489048.127925573);
		expectedCompanyValues.add(665388.4695090018);
		expectedCompanyValues.add(90554.34177023545);
		expectedCompanyValues.add(656667.4930005998);
		expectedCompanyValues.add(850297.0948003498);
		expectedCompanyValues.add(124600.83774218056);
		expectedCompanyValues.add(-459676.0191028721);
		expectedCompanyValues.add(678036.9898538261);
		expectedCompanyValues.add(-187614.91544920753);
		expectedCompanyValues.add(223770.57778748008);
		expectedCompanyValues.add(39669.68803907279);
		expectedCompanyValues.add(-338894.353485669);
		expectedCompanyValues.add(-488144.1039972181);
		expectedCompanyValues.add(966881.7240030055);
		expectedCompanyValues.add(150349.83673160034);
		expectedCompanyValues.add(22206.823144363938);
		expectedCompanyValues.add(-189827.98756976018);
		expectedCompanyValues.add(292067.44302606373);
		expectedCompanyValues.add(437318.8144613423);
		expectedCompanyValues.add(-215789.70813302358);
		expectedCompanyValues.add(421571.9303339694);
		expectedCompanyValues.add(-687273.9014928855);
		expectedCompanyValues.add(-81214.19070938509);
		expectedCompanyValues.add(-140616.4790195066);
		expectedCompanyValues.add(614049.6632955426);
		expectedCompanyValues.add(-697028.9106759268);
		expectedCompanyValues.add(-835568.6632776498);
		expectedCompanyValues.add(670977.4754765113);
		expectedCompanyValues.add(610157.5118208253);
		expectedCompanyValues.add(712386.8053300907);
		expectedCompanyValues.add(-504788.90760903974);
		expectedCompanyValues.add(-495045.02062730136);
		expectedCompanyValues.add(817820.5294115124);
		expectedCompanyValues.add(-838920.203848295);
		expectedCompanyValues.add(669817.3493428908);
		expectedCompanyValues.add(805545.3197140018);
		expectedCompanyValues.add(359240.7391932213);
		expectedCompanyValues.add(844529.6076907546);
		expectedCompanyValues.add(-312989.5633886637);
		expectedCompanyValues.add(263075.9496396915);
		expectedCompanyValues.add(16360.449380228994);
		expectedCompanyValues.add(68759.16810651612);
		expectedCompanyValues.add(889671.5932841017);
		expectedCompanyValues.add(-10204.704375256435);
		expectedCompanyValues.add(674245.1021235457);
		expectedCompanyValues.add(739860.308780371);
		expectedCompanyValues.add(425569.88819495356);
		expectedCompanyValues.add(339168.4047534978);
		expectedCompanyValues.add(619135.0913243904);
		expectedCompanyValues.add(-452074.04370832664);
		expectedCompanyValues.add(301477.1283187282);
		expectedCompanyValues.add(-3607.7602929807035);
		expectedCompanyValues.add(-364191.16853860323);
		expectedCompanyValues.add(-686044.2547163486);
		expectedCompanyValues.add(761403.6925586772);
		expectedCompanyValues.add(-147358.36981751);
		expectedCompanyValues.add(749287.885540742);
		expectedCompanyValues.add(509317.26274886867);
		expectedCompanyValues.add(526370.833333917);
		expectedCompanyValues.add(-127174.62448500097);
		expectedCompanyValues.add(-331193.0258577276);
		expectedCompanyValues.add(-689138.2046107766);
		expectedCompanyValues.add(552274.0634503679);
		expectedCompanyValues.add(-323605.5174618964);
		expectedCompanyValues.add(-482638.1752163844);
		expectedCompanyValues.add(-279192.5311938508);
		expectedCompanyValues.add(394033.30359983095);
		expectedCompanyValues.add(873012.5486982267);
		expectedCompanyValues.add(268038.31663235486);
		expectedCompanyValues.add(-740979.909775984);
		expectedCompanyValues.add(-991633.1624511739);
		expectedCompanyValues.add(329662.5946071076);
		expectedCompanyValues.add(458717.2895682864);
		expectedCompanyValues.add(526335.8018956301);
		expectedCompanyValues.add(-115834.48712730827);
		expectedCompanyValues.add(493030.696203429);
		expectedCompanyValues.add(-780360.0263245238);
		expectedCompanyValues.add(541086.7642243318);
		expectedCompanyValues.add(-241414.88212066167);
		expectedCompanyValues.add(-349227.4322561928);
		expectedCompanyValues.add(-576290.98299125);
		expectedCompanyValues.add(167006.33035837673);
		expectedCompanyValues.add(858615.2713025331);
		expectedCompanyValues.add(-412465.46526632225);
		expectedCompanyValues.add(-142707.89106892794);
		expectedCompanyValues.add(-820795.2901393678);
		expectedCompanyValues.add(602023.702321826);
		expectedCompanyValues.add(476366.0047098568);
		expectedCompanyValues.add(-290316.03175171977);
		expectedCompanyValues.add(555923.7329250926);
		expectedCompanyValues.add(-1784.7043286889093);
		expectedCompanyValues.add(-956573.4363035514);
		expectedCompanyValues.add(392274.8741123143);
		expectedCompanyValues.add(437293.04475783976);
		expectedCompanyValues.add(608686.6241020048);
		expectedCompanyValues.add(53655.76666277321);
		expectedCompanyValues.add(-276136.7721014727);
		expectedCompanyValues.add(-141673.23349964316);
		expectedCompanyValues.add(-141604.24098111957);
		expectedCompanyValues.add(987340.2038228293);
		expectedCompanyValues.add(-143559.17702523468);
		expectedCompanyValues.add(841915.331133992);
		expectedCompanyValues.add(-266489.7421841539);
		expectedCompanyValues.add(-587723.0949505306);
		expectedCompanyValues.add(966170.3312954484);
		expectedCompanyValues.add(728581.8699682094);
		expectedCompanyValues.add(457633.717327771);
		expectedCompanyValues.add(3499.151788264513);
		expectedCompanyValues.add(-302835.54536892334);
		expectedCompanyValues.add(723289.436035177);
		expectedCompanyValues.add(607754.8990230437);
		expectedCompanyValues.add(-577705.0349697144);
		expectedCompanyValues.add(621067.8267844892);
		expectedCompanyValues.add(-444400.08456840157);
		expectedCompanyValues.add(312802.0866091745);
		expectedCompanyValues.add(338515.1743484384);
		expectedCompanyValues.add(563332.0382339458);
		expectedCompanyValues.add(878001.6302720385);
		expectedCompanyValues.add(671826.6600121597);
		expectedCompanyValues.add(764933.649253842);
		expectedCompanyValues.add(-452534.02613941755);
		expectedCompanyValues.add(-431761.79812321824);
		expectedCompanyValues.add(335480.4637529501);
		expectedCompanyValues.add(-430313.39724318206);
		expectedCompanyValues.add(321433.92484581657);
		expectedCompanyValues.add(-545012.975225765);
		expectedCompanyValues.add(-686407.4251280035);
		expectedCompanyValues.add(-457414.67163026845);
		expectedCompanyValues.add(955764.2071836505);
		expectedCompanyValues.add(-847749.6102491955);
		expectedCompanyValues.add(503290.24096664065);
		expectedCompanyValues.add(-286639.16123777186);
		expectedCompanyValues.add(-159178.1124100755);
		expectedCompanyValues.add(-333660.446784255);
		expectedCompanyValues.add(-823748.3047549773);
		expectedCompanyValues.add(754665.5973378371);
		expectedCompanyValues.add(-438910.06215256767);
		expectedCompanyValues.add(-769653.573260329);
		expectedCompanyValues.add(-279683.17129305005);
		expectedCompanyValues.add(-750077.7462155339);
		expectedCompanyValues.add(-412806.02097675856);
		expectedCompanyValues.add(-575486.981517878);
		expectedCompanyValues.add(-700175.9880850464);
		expectedCompanyValues.add(365875.5576363837);
		expectedCompanyValues.add(-498204.6929788395);
		expectedCompanyValues.add(56925.893392226426);
		expectedCompanyValues.add(-219318.8163910684);
		expectedCompanyValues.add(41969.04588606884);
		expectedCompanyValues.add(563369.4319247594);
		expectedCompanyValues.add(507476.6055476866);
		expectedCompanyValues.add(260320.0581101249);
		expectedCompanyValues.add(-806566.4242295283);
		expectedCompanyValues.add(-187724.32641963626);
		expectedCompanyValues.add(279046.2675343985);
		expectedCompanyValues.add(849323.2327989214);
		expectedCompanyValues.add(-377759.28073969483);
		expectedCompanyValues.add(-363583.8032522119);
		expectedCompanyValues.add(-646613.0405209598);
		expectedCompanyValues.add(-29346.061354415026);
		expectedCompanyValues.add(339839.2892123782);
		expectedCompanyValues.add(739171.7472473469);
		expectedCompanyValues.add(-384810.8662125289);
		expectedCompanyValues.add(374059.8232301427);
		expectedCompanyValues.add(-172140.71108249237);
		expectedCompanyValues.add(-209806.70079698996);
		expectedCompanyValues.add(86339.11354580615);
		expectedCompanyValues.add(-692638.3575922474);
		expectedCompanyValues.add(397732.5787508406);
		expectedCompanyValues.add(690018.1504798215);
		expectedCompanyValues.add(-996613.1942894892);
		expectedCompanyValues.add(-157020.58510201983);
		expectedCompanyValues.add(-742553.6627741884);
		expectedCompanyValues.add(342371.10295927804);
		expectedCompanyValues.add(874759.4241374198);
		expectedCompanyValues.add(-772811.9769455076);
		expectedCompanyValues.add(-846590.6901948648);
		expectedCompanyValues.add(103400.51434333599);
		expectedCompanyValues.add(570271.9547469467);
		expectedCompanyValues.add(301236.4594982425);
		expectedCompanyValues.add(-472321.49655222194);
		expectedCompanyValues.add(664991.0797836154);
		expectedCompanyValues.add(-775997.7836784071);
		expectedCompanyValues.add(-462396.1565015422);
		expectedCompanyValues.add(-984442.7081619324);
		expectedCompanyValues.add(-970315.9146789253);
		expectedCompanyValues.add(272612.1025478146);
		expectedCompanyValues.add(41307.25125173142);
		expectedCompanyValues.add(-194155.88592574792);
		expectedCompanyValues.add(-552371.3361542728);
		expectedCompanyValues.add(304713.40105140046);
		expectedCompanyValues.add(-14683.626645315439);
		expectedCompanyValues.add(-104225.90548909351);
		expectedCompanyValues.add(-288624.00699984585);
		expectedCompanyValues.add(562892.5394271424);
		expectedCompanyValues.add(380770.74280140246);
		expectedCompanyValues.add(594963.1923702259);
		expectedCompanyValues.add(42220.807409637724);
		expectedCompanyValues.add(918522.7231531271);
		expectedCompanyValues.add(826835.7842864697);
		expectedCompanyValues.add(-232570.23261696892);
		expectedCompanyValues.add(-47816.03812710219);
		expectedCompanyValues.add(930509.24239993);
		expectedCompanyValues.add(-58324.28942591662);
		expectedCompanyValues.add(248033.2718119952);
		expectedCompanyValues.add(928621.2036901552);
		expectedCompanyValues.add(202628.1246192474);
		expectedCompanyValues.add(545159.2082039525);
		expectedCompanyValues.add(-370563.2276484226);
		expectedCompanyValues.add(-436166.42751127353);
		expectedCompanyValues.add(670134.6850059384);
		expectedCompanyValues.add(345557.95622813003);
		expectedCompanyValues.add(187964.130998892);
		expectedCompanyValues.add(839945.4944513582);
		expectedCompanyValues.add(674833.7482282198);
		expectedCompanyValues.add(876635.7910341944);
		expectedCompanyValues.add(101489.68389553251);
		expectedCompanyValues.add(679707.1383172127);
		expectedCompanyValues.add(728819.1107475492);
		expectedCompanyValues.add(738168.7050615698);
		expectedCompanyValues.add(-690237.0044496335);
		expectedCompanyValues.add(586768.9661888056);
		expectedCompanyValues.add(-279394.9488856895);
		expectedCompanyValues.add(-187924.9310468227);
		expectedCompanyValues.add(-622663.0783839233);
		expectedCompanyValues.add(-775634.1285757398);
		expectedCompanyValues.add(-16610.388998057577);
		expectedCompanyValues.add(-942021.9182827971);
		expectedCompanyValues.add(541533.6374960905);
		expectedCompanyValues.add(119239.57401330443);
		expectedCompanyValues.add(123702.47880332032);
		expectedCompanyValues.add(-263839.44561412337);
		expectedCompanyValues.add(762647.5022713016);
		expectedCompanyValues.add(-671980.955928111);
		expectedCompanyValues.add(-200290.58467692253);
		expectedCompanyValues.add(462515.13698360487);
		expectedCompanyValues.add(-959148.8886150508);
		expectedCompanyValues.add(-133831.93307895656);
		expectedCompanyValues.add(741957.0650293007);
		expectedCompanyValues.add(369231.8868449535);
		expectedCompanyValues.add(524034.5840587821);
		expectedCompanyValues.add(975001.208395978);
		expectedCompanyValues.add(-774639.5646516928);
		expectedCompanyValues.add(-173392.75195395062);
		expectedCompanyValues.add(3075.214893886354);
		expectedCompanyValues.add(-109841.54410072695);
		expectedCompanyValues.add(929750.0485980676);
		expectedCompanyValues.add(675497.4210130607);
		expectedCompanyValues.add(-724200.6285105828);
		expectedCompanyValues.add(-324678.8038263952);
		expectedCompanyValues.add(-332689.4983503743);
		expectedCompanyValues.add(-273418.27800803806);
		expectedCompanyValues.add(558164.8452961429);
		expectedCompanyValues.add(897840.9710813754);
		expectedCompanyValues.add(808759.2318626633);
		expectedCompanyValues.add(401740.08559866366);
		expectedCompanyValues.add(630956.6618676982);
		expectedCompanyValues.add(-551655.2494041191);
		expectedCompanyValues.add(406129.12450592965);
		expectedCompanyValues.add(-175508.5138482242);
		expectedCompanyValues.add(732555.8180292149);
		expectedCompanyValues.add(-355730.0403610397);
		expectedCompanyValues.add(-11465.872626906377);
		expectedCompanyValues.add(410578.8175040488);
		expectedCompanyValues.add(-656894.6217955996);
		expectedCompanyValues.add(907673.4242731542);
		expectedCompanyValues.add(798313.2328374512);
		expectedCompanyValues.add(66427.978201858);
		expectedCompanyValues.add(952664.5422394876);
		expectedCompanyValues.add(-229450.51842756546);
		expectedCompanyValues.add(-161536.95060083352);
		expectedCompanyValues.add(-527651.6100657445);
		expectedCompanyValues.add(-334293.7214523079);
		expectedCompanyValues.add(736282.2659407295);
		expectedCompanyValues.add(-481714.18669209356);
		expectedCompanyValues.add(608983.28352315);
		expectedCompanyValues.add(66580.49207289983);
		expectedCompanyValues.add(-386251.2280343757);
		expectedCompanyValues.add(912694.0329759829);
		expectedCompanyValues.add(-320340.5825550334);
		expectedCompanyValues.add(-844670.4839935984);
		expectedCompanyValues.add(-659021.1444138284);
		expectedCompanyValues.add(-308370.06798435014);
		expectedCompanyValues.add(-112075.85899612599);
		expectedCompanyValues.add(360509.3172456343);
		expectedCompanyValues.add(-971829.6880352651);
		expectedCompanyValues.add(-370427.54595115373);
		expectedCompanyValues.add(-851297.8536803692);
		expectedCompanyValues.add(-354565.8052520477);
		expectedCompanyValues.add(-24753.953446425847);
		expectedCompanyValues.add(-728879.3117496625);
		expectedCompanyValues.add(743140.565134522);
		expectedCompanyValues.add(546529.6359723122);
		expectedCompanyValues.add(-242966.98022606655);
		expectedCompanyValues.add(807157.9635240391);
		expectedCompanyValues.add(-828644.4996505267);
		expectedCompanyValues.add(-382757.2398425208);
		expectedCompanyValues.add(-880468.8617413745);
		expectedCompanyValues.add(507117.3294166548);
		expectedCompanyValues.add(-986068.8755618045);
		expectedCompanyValues.add(198225.72631472466);
		expectedCompanyValues.add(393632.9015964875);
		expectedCompanyValues.add(-843617.359773247);
		expectedCompanyValues.add(-517835.739750232);
		expectedCompanyValues.add(694272.8601789598);
		expectedCompanyValues.add(408043.6145524394);
		expectedCompanyValues.add(863878.3895259986);
		expectedCompanyValues.add(-481312.1225957464);
		expectedCompanyValues.add(-389241.33270974876);
		expectedCompanyValues.add(-528956.3410874149);
		expectedCompanyValues.add(-666586.5922937002);
		expectedCompanyValues.add(-195752.79720831022);
		expectedCompanyValues.add(-512911.6611668671);
		expectedCompanyValues.add(891124.424687726);
		expectedCompanyValues.add(233362.1846657924);
		expectedCompanyValues.add(833043.1698811052);
		expectedCompanyValues.add(-438061.36245867796);
		expectedCompanyValues.add(719420.0837610874);
		expectedCompanyValues.add(652781.2606398195);
		expectedCompanyValues.add(338198.2583192652);
		expectedCompanyValues.add(514833.14632245456);
		expectedCompanyValues.add(922248.8078148116);
		expectedCompanyValues.add(-201925.02349563607);
		expectedCompanyValues.add(780540.6245438552);
		expectedCompanyValues.add(-49139.688042533235);
		expectedCompanyValues.add(-970033.8427289483);
		expectedCompanyValues.add(-937160.7122078349);
		expectedCompanyValues.add(358043.0507947358);
		expectedCompanyValues.add(430109.4541888335);
		expectedCompanyValues.add(-541274.3173354261);
		expectedCompanyValues.add(394529.6289793828);
		expectedCompanyValues.add(-950106.654043497);
		expectedCompanyValues.add(790664.7048012351);
		expectedCompanyValues.add(164630.99603466433);
		expectedCompanyValues.add(-514887.59018778696);
		expectedCompanyValues.add(578314.2648498439);
		expectedCompanyValues.add(273763.32780072023);
		expectedCompanyValues.add(-934844.5605669746);
		expectedCompanyValues.add(728877.2331405596);
		expectedCompanyValues.add(-147108.7006846246);
		expectedCompanyValues.add(-468010.8237878864);
		expectedCompanyValues.add(-249405.33412445313);
		expectedCompanyValues.add(119101.28075927636);
		expectedCompanyValues.add(-543693.12221699);

		
		return expectedCompanyValues;
	}
	
	private List<Double> getSmallCompanyValuesRange(){
		
		List<Double> companyValues = new ArrayList<>();
	
		companyValues.add(-7.329767994387009);
		companyValues.add(-9.420849590677536);
		companyValues.add(4.802066549509934);
		companyValues.add(-4.5885255922401775);
		companyValues.add(-8.342023425673162);
		companyValues.add(5.58053972660344);
		companyValues.add(9.077027029255103);
		companyValues.add(0.5141543501644961);
		companyValues.add(0.5137662190451824);
		companyValues.add(9.752387865275072);
		companyValues.add(-3.2862183651515364);
		companyValues.add(4.048466552239514);
		companyValues.add(-7.473883488834236);
		companyValues.add(-1.9229224260063997);
		companyValues.add(-5.658447972780484);
		companyValues.add(2.943565003072221);
		companyValues.add(-6.22282476196821);
		companyValues.add(6.932320277442212);
		companyValues.add(-4.307654009217559);
		companyValues.add(1.2939549110132234);
		companyValues.add(1.4386150584171773);
		companyValues.add(6.399370287990706);
		companyValues.add(6.748437619638274);
		companyValues.add(2.147851321169586);
		companyValues.add(3.499128748893863);
		companyValues.add(7.781682208792443);
		companyValues.add(6.706520015399619);
		companyValues.add(-9.280339925764148);
		companyValues.add(3.7766674165580145);
		companyValues.add(-5.022810529568704);
		companyValues.add(-1.1441868397467836);
		companyValues.add(-1.695464236937294);
		companyValues.add(-2.036887376994261);
		companyValues.add(-2.726818882010531);
		companyValues.add(-7.325541305796608);
		companyValues.add(2.9112499778017096);
		companyValues.add(3.968585833455993);
		companyValues.add(-9.31647266678328);
		companyValues.add(-8.719457944813671);
		companyValues.add(-0.00711409071112179);
		companyValues.add(2.977142114907041);
		companyValues.add(5.1237800495487456);
		companyValues.add(-3.168865718585736);
		companyValues.add(4.643163793655578);
		companyValues.add(-3.6048766354169715);
		companyValues.add(5.520469191278437);
		companyValues.add(-9.455232586813425);
		companyValues.add(5.239464734567324);
		companyValues.add(8.267975051886943);
		companyValues.add(6.376686117000169);
		companyValues.add(-6.270213880605551);
		companyValues.add(-2.2480754078316085);
		companyValues.add(2.76086158978776);
		companyValues.add(-8.633170167665895);
		companyValues.add(-8.466944299812997);
		companyValues.add(9.80123202929638);
		companyValues.add(1.9429546774743294);
		companyValues.add(2.209172066617821);
		companyValues.add(2.080535696411891);
		companyValues.add(-5.963942124530406);
		companyValues.add(0.38478647288405554);
		companyValues.add(-5.63431369634513);
		companyValues.add(0.26325761116652124);
		companyValues.add(-8.485683062337275);
		companyValues.add(-0.027396458876964402);
		companyValues.add(-8.95565035888977);
		companyValues.add(-2.3707208105548734);
		companyValues.add(-2.489249857542106);
		companyValues.add(-9.136819202856676);
		companyValues.add(1.5299275116178492);
		companyValues.add(-2.325782930277798);
		companyValues.add(4.536591787023767);
		companyValues.add(2.6470916890264675);
		companyValues.add(5.045022477866986);
		companyValues.add(9.279991568931642);
		companyValues.add(-9.654630498234331);
		companyValues.add(3.557953935680505);
		companyValues.add(-2.8560565114905483);
		companyValues.add(-9.86654989845608);
		companyValues.add(2.3121682190100366);
		companyValues.add(-5.040287977755053);
		companyValues.add(-7.932250668904222);
		companyValues.add(6.663562409776688);
		companyValues.add(3.81196803927239);
		companyValues.add(-6.636461865120429);
		companyValues.add(-8.46041380375234);
		companyValues.add(-2.6320801271628325);
		companyValues.add(-6.914056736188714);
		companyValues.add(-7.1295227146050655);
		companyValues.add(8.155230302272802);
		companyValues.add(-7.643709219997417);
		companyValues.add(0.5729021125454636);
		companyValues.add(-2.79452658904704);
		companyValues.add(9.824520400152156);
		companyValues.add(-6.478968720986382);
		companyValues.add(-3.2036828868487195);
		companyValues.add(2.402973191211233);
		companyValues.add(-9.354846128213591);
		companyValues.add(-3.0488381154470616);
		companyValues.add(-0.3643176188116257);
		companyValues.add(-1.276194977625666);
		companyValues.add(-6.858906944836645);
		companyValues.add(2.0389727157997797);
		companyValues.add(-2.8257866373412615);
		companyValues.add(3.527585869521637);
		companyValues.add(6.97362024741761);
		companyValues.add(0.18503387871309407);
		companyValues.add(0.3031898944862217);
		companyValues.add(-4.405575292012629);
		companyValues.add(-9.966155046954366);
		companyValues.add(-9.910472028951524);
		companyValues.add(7.876518561756264);
		companyValues.add(-4.215767963531025);
		companyValues.add(-0.7487284790317617);
		companyValues.add(6.324856187556648);
		companyValues.add(6.4473761548045445);
		companyValues.add(8.941471159868218);
		companyValues.add(0.5037896457087534);
		companyValues.add(-6.783516365770684);
		companyValues.add(-3.5179247309582085);
		companyValues.add(7.5977164800194075);
		companyValues.add(9.690253536412023);
		companyValues.add(7.016047298844608);
		companyValues.add(-2.56542441948387);
		companyValues.add(-0.7060756519887317);
		companyValues.add(0.327586522426607);
		companyValues.add(5.932756004964158);
		companyValues.add(-4.821654697727215);
		companyValues.add(-3.76115906374487);
		companyValues.add(-3.0398721090612923);
		companyValues.add(9.796155600961196);
		companyValues.add(-2.9694459016353942);
		companyValues.add(-1.460487406816993);
		companyValues.add(-1.7802715632726862);
		companyValues.add(-1.0446330791027059);
		companyValues.add(-8.033127238432279);
		companyValues.add(-9.61560911035869);
		companyValues.add(-1.4491307459321767);
		companyValues.add(-4.523074578140056);
		companyValues.add(-3.3865832243902316);
		companyValues.add(-7.670942680741151);
		companyValues.add(3.4158762741634714);
		companyValues.add(8.785387866906333);
		companyValues.add(1.2156723066202098);
		companyValues.add(-7.770877267362324);
		companyValues.add(-0.7789349149023792);
		companyValues.add(-7.402096983524991);
		companyValues.add(-5.97749268842813);
		companyValues.add(-7.615613548671778);
		companyValues.add(6.255455641330126);
		companyValues.add(-9.664021045277075);
		companyValues.add(-2.613334438982231);
		companyValues.add(1.102879158949099);
		companyValues.add(-9.390554069479947);
		companyValues.add(2.1546934827005177);
		companyValues.add(-5.628587684858212);
		companyValues.add(3.1629320031513153);
		companyValues.add(-0.6583476113239968);
		companyValues.add(8.3116521187473);
		companyValues.add(0.7662888892863755);
		companyValues.add(5.5459565668901);
		companyValues.add(-7.912129614786869);
		companyValues.add(-9.194995901549149);
		companyValues.add(4.15320661514134);
		companyValues.add(-7.6678525603873275);
		companyValues.add(-8.143081279791431);
		companyValues.add(8.041875431370965);
		companyValues.add(9.027403913414751);
		companyValues.add(-4.204151080109481);
		companyValues.add(7.933890365844029);
		companyValues.add(-4.244402274108287);
		companyValues.add(-5.033941956469636);
		companyValues.add(-0.49313949323329354);
		companyValues.add(-5.387870864164219);
		companyValues.add(-8.52784719902527);
		companyValues.add(-6.549368816741168);
		companyValues.add(-6.361508308394306);
		companyValues.add(0.9010236115149883);
		companyValues.add(9.533276129135665);
		companyValues.add(-1.8126817474099948);
		companyValues.add(2.702692495760301);
		companyValues.add(-1.5925021895664777);
		companyValues.add(9.015696104928058);
		companyValues.add(3.633227787755951);
		companyValues.add(1.5771388363202696);
		companyValues.add(7.264851460493141);
		companyValues.add(-2.1569776350784142);
		companyValues.add(-3.0757740963056923);
		companyValues.add(6.958665742703705);
		companyValues.add(-6.716607963978394);
		companyValues.add(2.9688179112807784);
		companyValues.add(9.51364586163811);
		companyValues.add(-1.7280174459709468);
		companyValues.add(3.4230764176485007);
		companyValues.add(8.716428500071085);
		companyValues.add(6.569345659555644);
		companyValues.add(4.582127201531005);
		companyValues.add(1.2391630168921264);
		companyValues.add(3.1931730173440585);
		companyValues.add(-5.460114526995121);
		companyValues.add(-7.7963406292915005);
		companyValues.add(-0.8723419915238733);
		companyValues.add(-3.846472168536728);
		companyValues.add(0.28886767842839234);
		companyValues.add(1.4691100409330087);
		companyValues.add(-0.001882531797875231);
		companyValues.add(0.7679675711201224);
		companyValues.add(-1.1902275610540158);
		companyValues.add(-9.486249037942278);
		companyValues.add(-2.572847953404902);
		companyValues.add(6.461164269820273);
		companyValues.add(0.7718959595396058);
		companyValues.add(8.953260655368982);
		companyValues.add(0.39675801339690864);
		companyValues.add(-9.684734655117841);
		companyValues.add(-3.988713971531748);
		companyValues.add(4.97541653570009);
		companyValues.add(6.397383284494463);
		companyValues.add(0.49101612589394605);
		companyValues.add(4.568844724801357);
		companyValues.add(5.636453488274913);
		companyValues.add(4.976416576034058);
		companyValues.add(-3.2984869438923026);
		companyValues.add(-7.008943479907474);
		companyValues.add(2.0472739918094103);
		companyValues.add(-7.261429535057302);
		companyValues.add(9.980407109357735);
		companyValues.add(-9.65292777084511);
		companyValues.add(-1.3457776014207319);
		companyValues.add(0.3554050360840968);
		companyValues.add(6.818415646171431);
		companyValues.add(5.779168451222848);
		companyValues.add(8.9636611637221);
		companyValues.add(-7.682967598273671);
		companyValues.add(-8.800978370017399);
		companyValues.add(7.391879678263081);
		companyValues.add(-1.1708685843213118);
		companyValues.add(0.9598068992431266);
		companyValues.add(-7.853723293521759);
		companyValues.add(-9.101618072938608);
		companyValues.add(-7.185604598419353);
		companyValues.add(-2.270399783389636);
		companyValues.add(4.104655572273135);
		companyValues.add(5.680989297705313);
		companyValues.add(9.165206312415695);
		companyValues.add(6.691039166716518);
		companyValues.add(-7.197062504360234);
		companyValues.add(-4.214096793188579);
		companyValues.add(-5.432836156348973);
		companyValues.add(7.968856761593923);
		companyValues.add(-9.788875151450725);
		companyValues.add(-6.139360485807495);
		companyValues.add(-8.863437492802191);
		companyValues.add(2.10830472674189);
		companyValues.add(-1.2185620669860135);
		companyValues.add(-2.844166226746112);
		companyValues.add(4.98566189330135);
		companyValues.add(-9.732665239146897);
		companyValues.add(7.371457984266545);
		companyValues.add(-3.548584981753285);
		companyValues.add(-1.7766613451404094);
		companyValues.add(9.70406371025247);
		companyValues.add(9.07952094227053);
		companyValues.add(1.1304113710581891);
		companyValues.add(-5.603387008657565);
		companyValues.add(9.198791572200566);
		companyValues.add(4.679494295502103);
		companyValues.add(6.611936108806336);
		companyValues.add(-8.851921261023989);
		companyValues.add(-5.149353632876834);
		companyValues.add(-5.575893340454929);
		companyValues.add(3.968182203690624);
		companyValues.add(-6.741214139386926);
		companyValues.add(3.1146925494887157);
		companyValues.add(5.6930179357131365);
		companyValues.add(-4.211461946788462);
		companyValues.add(-5.734329315875875);
		companyValues.add(4.996134266272758);
		companyValues.add(-5.706132732422944);
		companyValues.add(-2.782784758916275);
		companyValues.add(5.48714186547587);
		companyValues.add(-7.005979839272063);
		companyValues.add(-6.818450479293561);
		companyValues.add(6.579057859485282);
		companyValues.add(-2.4400194244888134);
		companyValues.add(-9.312366580854164);
		companyValues.add(3.9430163044071485);
		companyValues.add(6.121494400662918);
		companyValues.add(1.4852323883967156);
		companyValues.add(-6.215456921479103);
		companyValues.add(-6.398080500550362);
		companyValues.add(0.1388593433760743);
		companyValues.add(-6.299702491988053);
		companyValues.add(1.0000647887433374);
		companyValues.add(-7.870551278541786);
		companyValues.add(-4.891391058374821);
		companyValues.add(2.83897484296023);
		companyValues.add(3.313661354503111);
		companyValues.add(4.504751983208642);
		companyValues.add(-5.542778811353135);
		companyValues.add(4.610719062324877);
		companyValues.add(-9.05139989493791);
		companyValues.add(-4.749651927226342);
		companyValues.add(-0.8131327447582066);
		companyValues.add(-4.3750705393315625);
		companyValues.add(8.846959063170175);
		companyValues.add(-6.92501903453234);
		companyValues.add(-5.167792292794711);
		companyValues.add(-2.9943987780247516);
		companyValues.add(3.4628602534735613);
		companyValues.add(-1.4116084031926412);
		companyValues.add(5.07995901043979);
		companyValues.add(-5.713795870229488);
		companyValues.add(-3.627415151881415);
		companyValues.add(-0.9904784643597679);
		companyValues.add(2.872152809012549);
		companyValues.add(-8.65580129443874);
		companyValues.add(-6.498989435598488);
		companyValues.add(0.37167538399175726);
		companyValues.add(-9.072709013554242);
		companyValues.add(3.029108380389534);
		companyValues.add(-7.31040928700077);
		companyValues.add(-0.06476871893895364);
		companyValues.add(-4.648118492273863);
		companyValues.add(-6.342381813133415);
		companyValues.add(6.881872804026173);
		companyValues.add(-0.6495151219511968);
		companyValues.add(-1.621875617032698);
		companyValues.add(6.693688711577309);
		companyValues.add(-4.621652446940407);
		companyValues.add(2.5702730063729256);
		companyValues.add(9.251790680328533);
		companyValues.add(4.701211718340112);
		companyValues.add(-8.586822385449821);
		companyValues.add(-8.405963966485846);
		companyValues.add(-4.092368361873193);
		companyValues.add(8.051262033226472);
		companyValues.add(-9.268832081414661);
		companyValues.add(7.832014709856832);
		companyValues.add(-5.692083166035793);
		companyValues.add(5.885533873647519);
		companyValues.add(2.894086591485456);
		companyValues.add(7.2103137185437625);
		companyValues.add(-2.816993643924337);
		companyValues.add(-6.517922220656844);
		companyValues.add(4.7212582314075835);
		companyValues.add(3.0945852473881796);
		companyValues.add(-0.5988839744959211);
		companyValues.add(6.438990371830233);
		companyValues.add(-6.429893296584995);
		companyValues.add(2.692128364136595);
		companyValues.add(3.307743331422323);
		companyValues.add(-6.0137669347983325);
		companyValues.add(-2.9118742696198785);
		companyValues.add(-0.2007838898622989);
		companyValues.add(4.113477577583742);
		companyValues.add(1.2552985695326235);
		companyValues.add(-4.381478377671226);
		companyValues.add(9.59251938599352);
		companyValues.add(2.772220335251397);
		companyValues.add(-6.519038538893545);
		companyValues.add(-6.382433907716756);
		companyValues.add(-0.37951121021852074);
		companyValues.add(-8.219895663773244);
		companyValues.add(-6.121110180992842);
		companyValues.add(-2.7575333066988623);
		companyValues.add(5.232631297529306);
		companyValues.add(7.93870207713422);
		companyValues.add(1.3374270568518014);
		companyValues.add(-3.3056443370461253);
		companyValues.add(-2.6083849719055197);
		companyValues.add(5.364372322114226);
		companyValues.add(4.08137363132351);
		companyValues.add(-6.048231017634715);
		companyValues.add(-3.854817751427295);
		companyValues.add(-8.111106015405403);
		companyValues.add(-8.88985575940709);
		companyValues.add(-0.7942262019361905);
		companyValues.add(-6.008119995483312);
		companyValues.add(-7.515192562004804);
		companyValues.add(4.482193493479727);
		companyValues.add(2.608683750712032);
		companyValues.add(9.956653441468884);
		companyValues.add(-5.537831848418913);
		companyValues.add(-7.587852435350184);
		companyValues.add(-8.125918814503185);
		companyValues.add(-2.600638099513766);
		companyValues.add(-9.078303892387442);
		companyValues.add(-4.333403485984344);
		companyValues.add(-9.183354335175515);
		companyValues.add(-3.5886702610563015);
		companyValues.add(-8.687409859509174);
		companyValues.add(7.8890441918983925);
		companyValues.add(-0.9039240765440262);
		companyValues.add(-4.887935698372045);
		companyValues.add(-9.068444263278327);
		companyValues.add(-5.745957575510012);
		companyValues.add(-0.7698373365909905);
		companyValues.add(3.2403021830622496);
		companyValues.add(4.81286884028467);
		companyValues.add(-7.754940264786847);
		companyValues.add(3.3678590377049655);
		companyValues.add(6.140581582114319);
		companyValues.add(-4.302403376273989);
		companyValues.add(-6.629823951427955);
		companyValues.add(-0.6360213116506337);
		companyValues.add(-2.421427276580843);
		companyValues.add(0.6333549359947348);
		companyValues.add(-4.7257806286522825);
		companyValues.add(3.372923314459239);
		companyValues.add(5.775418682114321);
		companyValues.add(6.244288246496726);
		companyValues.add(-0.024507806623230266);
		companyValues.add(-5.52037112079228);
		companyValues.add(8.633379175462032);
		companyValues.add(-1.1757878706848484);
		companyValues.add(-4.1502248092707745);
		companyValues.add(-4.1882952680770735);
		companyValues.add(1.3321001747968904);
		companyValues.add(2.1441673643533683);
		companyValues.add(-1.4961896307285052);
		companyValues.add(-3.8724887966748023);
		companyValues.add(-7.693138515412377);
		companyValues.add(-6.771110205179085);
		companyValues.add(-1.1749856370164302);
		companyValues.add(-3.949290676093793);
		companyValues.add(2.07718213618897);
		companyValues.add(-5.6549948168906035);
		companyValues.add(-4.736306491810625);
		companyValues.add(-6.07739874971045);
		companyValues.add(3.476204453247501);
		companyValues.add(-1.9429819177382246);
		companyValues.add(-8.201433916786442);
		companyValues.add(-2.3306546292125834);
		companyValues.add(-8.4617008188426);
		companyValues.add(-8.554538067548659);
		companyValues.add(3.0559288317361233);
		companyValues.add(1.1319349078806784);
		companyValues.add(6.634371003156968);
		companyValues.add(5.444850424185827);
		companyValues.add(3.6973372594868046);
		companyValues.add(-4.017413284735154);
		companyValues.add(-4.5986286453143155);
		companyValues.add(5.747350126868842);
		companyValues.add(-9.539802560467303);
		companyValues.add(3.6519840091338125);
		companyValues.add(0.5945606828092398);
		companyValues.add(2.831382356955114);
		companyValues.add(-7.8697995800148135);
		companyValues.add(5.617592180779329);
		companyValues.add(3.1980905757277363);
		companyValues.add(-9.587362607398243);
		companyValues.add(5.244061646928287);
		companyValues.add(4.954047730480175);
		companyValues.add(-2.038490570460432);
		companyValues.add(3.9782681871408325);
		companyValues.add(-8.53444260722666);
		companyValues.add(7.2224025687158);
		companyValues.add(6.98682011449479);
		companyValues.add(4.0533102808332355);
		companyValues.add(6.347386360725011);
		companyValues.add(4.575788853918425);
		companyValues.add(5.072764551283239);
		companyValues.add(-7.538339611953042);
		companyValues.add(-1.4140946341181788);
		companyValues.add(3.3848448316249264);
		companyValues.add(5.230021585051158);
		companyValues.add(4.082220561863377);
		companyValues.add(3.89533171768732);
		companyValues.add(-7.26296456199746);
		companyValues.add(-6.886948317669798);
		companyValues.add(1.4640996658491918);
		companyValues.add(-1.727469778233008);
		companyValues.add(8.839764749561368);
		companyValues.add(5.071345169249211);
		companyValues.add(-4.846951615497412);
		companyValues.add(-8.306971046859232);
		companyValues.add(8.657977755657498);
		companyValues.add(-3.8951357490468013);
		companyValues.add(-1.3054222511226161);
		companyValues.add(-4.82654788528452);
		companyValues.add(5.042715769628785);
		companyValues.add(1.2155003850998636);
		companyValues.add(4.017497983966434);
		companyValues.add(1.6550744892589808);
		companyValues.add(-4.842120595519319);
		companyValues.add(-3.5216010812653202);
		companyValues.add(-9.735101693669037);
		companyValues.add(4.307747142174005);
		companyValues.add(-5.811771832951164);
		companyValues.add(-5.385964782006452);
		companyValues.add(-2.8721437008024653);
		companyValues.add(-5.377037594017839);
		companyValues.add(7.1124340866680775);
		companyValues.add(3.923959631853922);
		companyValues.add(2.3504650535013027);
		companyValues.add(-2.940629474392753);
		companyValues.add(-7.249218431515738);
		companyValues.add(-0.8398499824237664);
		companyValues.add(2.313035696325972);
		companyValues.add(7.023579704341451);
		companyValues.add(-3.6521116946722643);
		companyValues.add(-1.7700389542713584);
		companyValues.add(4.463612764035725);
		companyValues.add(4.613609175178066);
		companyValues.add(9.626609615293276);
		companyValues.add(9.59566697514975);
		companyValues.add(0.8562322022750202);
		companyValues.add(-2.178104298996548);
		companyValues.add(0.5500568549595748);
		companyValues.add(-8.190351550157114);
		companyValues.add(3.167619336025451);
		companyValues.add(5.789283242399923);
		companyValues.add(-1.0455415336591187);
		companyValues.add(8.833285607714512);
		companyValues.add(1.3023170179566215);
		companyValues.add(5.220959682007948);
		companyValues.add(8.766355972223963);
		companyValues.add(-7.380333108693577);
		companyValues.add(0.05950971506898739);
		companyValues.add(-8.780172633723623);
		companyValues.add(2.6934256828701297);
		companyValues.add(-2.1027556815342185);
		companyValues.add(-8.676911606273352);
		companyValues.add(7.562342773873127);
		companyValues.add(1.0789796836736585);
		companyValues.add(-6.826401140848393);
		companyValues.add(-7.150211221988034);
		companyValues.add(0.8363701739962615);
		companyValues.add(3.036003728256338);
		companyValues.add(-3.3144837753125467);
		companyValues.add(8.968512812415234);
		companyValues.add(7.880142779401346);
		companyValues.add(5.027343173490252);
		companyValues.add(-3.6464025835399188);
		companyValues.add(3.3672209840606815);
		companyValues.add(-3.394054129056716);
		companyValues.add(9.73445566822858);
		companyValues.add(8.75666334616798);
		companyValues.add(-0.36792384489698726);
		companyValues.add(6.561677058511979);
		companyValues.add(-3.64208263320479);
		companyValues.add(-6.2767564699431695);
		companyValues.add(1.3167833171459353);
		companyValues.add(-2.52204664815525);
		companyValues.add(-7.581357613001707);
		companyValues.add(8.344473023745675);
		companyValues.add(-9.94162963230864);
		companyValues.add(-8.43200781478751);
		companyValues.add(-3.3204153389472975);
		companyValues.add(-2.955255796937273);
		companyValues.add(-2.3810815840572648);
		companyValues.add(8.491993538574341);
		companyValues.add(-7.016567369830462);
		companyValues.add(-7.1964962096480996);
		companyValues.add(-4.278956693016733);
		companyValues.add(0.6673114377206844);
		companyValues.add(5.602632997588604);
		companyValues.add(8.703604183356632);
		companyValues.add(6.158209498039216);
		companyValues.add(1.0002097641651968);
		companyValues.add(-1.8761828729781946);
		companyValues.add(8.688662328985167);
		companyValues.add(2.899231770893353);
		companyValues.add(-4.865452190232);
		companyValues.add(9.93952133498668);
		companyValues.add(1.7438933666677734);
		companyValues.add(-2.230391704002816);
		companyValues.add(5.95725520302568);
		companyValues.add(-2.904147410389779);
		companyValues.add(4.6719418692284815);
		companyValues.add(-8.21938909506678);
		companyValues.add(9.370005239224582);
		companyValues.add(-2.454464942509169);
		companyValues.add(5.217234769734107);
		companyValues.add(-4.709668497678545);
		companyValues.add(7.231008739647006);
		companyValues.add(-5.218436751226685);
		companyValues.add(9.499441123545623);
		companyValues.add(-8.080825821862181);
		companyValues.add(5.890395593064294);
		companyValues.add(8.377459164768062);
		companyValues.add(-4.4513646587410545);
		companyValues.add(3.505558580208186);
		companyValues.add(6.8871735575963555);
		companyValues.add(-4.864082769168585);
		companyValues.add(-1.80820752415908);
		companyValues.add(6.37587905773);
		companyValues.add(-9.854706044201098);
		companyValues.add(0.3483965678460681);
		companyValues.add(-0.3777064241901211);
		companyValues.add(-7.183944771225537);
		companyValues.add(-0.599127460484354);
		companyValues.add(-4.905987263365265);
		companyValues.add(-5.308877155145053);
		companyValues.add(5.870277195048853);
		companyValues.add(4.612159611387888);
		companyValues.add(-7.443150646197891);
		companyValues.add(0.2904965126375476);
		companyValues.add(0.4558423956290696);
		companyValues.add(-3.251626879208165);
		companyValues.add(-5.9834061400583405);
		companyValues.add(4.157673401683329);
		companyValues.add(-0.728744837669284);
		companyValues.add(6.623045414764764);
		companyValues.add(-6.531801758367381);
		companyValues.add(0.008741127639535051);
		companyValues.add(-1.9119587650371628);
		companyValues.add(-8.66793581871914);
		companyValues.add(8.752018042776072);
		companyValues.add(-6.880798585020555);
		companyValues.add(-8.244985463353562);
		companyValues.add(-0.623878696141313);
		companyValues.add(6.626695260659442);
		companyValues.add(3.3002003000391547);
		companyValues.add(-0.392985350923464);
		companyValues.add(8.691809124089175);
		companyValues.add(9.39280737270796);
		companyValues.add(0.6762935323720871);
		companyValues.add(6.958408280875432);
		companyValues.add(-9.414859838318261);
		companyValues.add(-8.523899447434546);
		companyValues.add(3.752659570319297);
		companyValues.add(7.974936854605996);
		companyValues.add(6.955799960969166);
		companyValues.add(-4.19509711151441);
		companyValues.add(8.966706470089875);
		companyValues.add(-5.544230182387626);
		companyValues.add(-1.7800376083707476);
		companyValues.add(1.8670874181238304);
		companyValues.add(6.25104978836432);
		companyValues.add(4.9209066939792265);
		companyValues.add(4.984041470715592);
		companyValues.add(0.007750373673129474);
		companyValues.add(6.091871720892442);
		companyValues.add(8.887347424550256);
		companyValues.add(7.791277399341499);
		companyValues.add(9.829537420005323);
		companyValues.add(0.14869993119918234);
		companyValues.add(-7.669261333437396);
		companyValues.add(6.157584736689735);
		companyValues.add(4.48333903989621);
		companyValues.add(-0.2913204927578228);
		companyValues.add(-7.932520695845591);
		companyValues.add(-9.367368063225213);
		companyValues.add(7.187857262320083);
		companyValues.add(4.080436232360064);
		companyValues.add(-0.8444485766555498);
		companyValues.add(9.766636298637735);
		companyValues.add(-8.507676185476484);
		companyValues.add(4.489673374410103);
		companyValues.add(-5.599372828422354);
		companyValues.add(-2.367094859041943);
		companyValues.add(2.5974346389183367);
		companyValues.add(8.120652945366988);
		companyValues.add(-7.332721688118471);
		companyValues.add(6.950674890916819);
		companyValues.add(3.475347717003636);
		companyValues.add(-8.345223836120716);
		companyValues.add(-3.0666020978217867);
		companyValues.add(7.872340968141025);
		companyValues.add(-3.419637166044409);
		companyValues.add(3.9894741778101572);
		companyValues.add(-2.1107700028420613);
		companyValues.add(3.143687548169547);
		companyValues.add(-0.38230004393148675);
		companyValues.add(-6.222323473434786);
		companyValues.add(0.37067540392749976);
		companyValues.add(-3.384723485294474);
		companyValues.add(2.138557376222712);
		companyValues.add(-0.989854917469275);
		companyValues.add(-5.9701699802083);
		companyValues.add(-6.022334455778338);
		companyValues.add(-1.3445760031514897);
		companyValues.add(3.0699956731352867);
		companyValues.add(-7.616009681081792);
		companyValues.add(-7.887320243233294);
		companyValues.add(3.522392593595571);
		companyValues.add(-5.479241121602505);
		companyValues.add(1.747645717646293);
		companyValues.add(6.597469114023067);
		companyValues.add(3.001010187029191);
		companyValues.add(6.346363967981581);
		companyValues.add(9.540248676178663);
		companyValues.add(-4.332369717547532);
		companyValues.add(-9.267022654208825);
		companyValues.add(-5.55653828754944);
		companyValues.add(0.07584893233910606);
		companyValues.add(3.340201573419055);
		companyValues.add(4.2667894262689625);
		companyValues.add(4.873531385465885);
		companyValues.add(-4.821051260868292);
		companyValues.add(4.4168617641943015);
		companyValues.add(-7.663799685017736);
		companyValues.add(-5.285749968447943);
		companyValues.add(-3.1657798649810553);
		companyValues.add(9.732205809884917);
		companyValues.add(-4.735840065189709);
		companyValues.add(-7.693365568554597);
		companyValues.add(-0.4339908929452214);
		companyValues.add(1.2814957217044043);
		companyValues.add(-5.833331546205889);
		companyValues.add(9.276490405374435);
		companyValues.add(1.3568299458697766);
		companyValues.add(-6.243185330697298);
		companyValues.add(-1.4432329672292568);
		companyValues.add(8.915748466081205);
		companyValues.add(-6.347666709433875);
		companyValues.add(1.5400902403553225);
		companyValues.add(-3.500338927379916);
		companyValues.add(-6.658717719680684);
		companyValues.add(-6.636482208811105);
		companyValues.add(8.345977003598318);
		companyValues.add(6.6457651548258845);
		companyValues.add(-4.694154502259435);
		companyValues.add(-7.2347681166572);
		companyValues.add(-9.52287500000158);
		companyValues.add(7.269227785139595);
		companyValues.add(9.617794649278618);
		companyValues.add(6.803293774881251);
		companyValues.add(-5.9511134170189495);
		companyValues.add(-6.134717243171592);
		companyValues.add(-6.166711976877098);
		companyValues.add(-8.439160976010502);
		companyValues.add(-8.439946419493584);
		companyValues.add(-6.089446162943624);
		companyValues.add(8.216696669796185);
		companyValues.add(-7.50220770009671);
		companyValues.add(3.830737872777865);
		companyValues.add(5.066217997970952);
		companyValues.add(-9.078021761637567);
		companyValues.add(-3.4343686937463858);
		companyValues.add(9.598046038203982);
		companyValues.add(1.4047179076967957);
		companyValues.add(-4.070190807771931);
		companyValues.add(8.412896512952223);
		companyValues.add(-3.045266356569658);
		companyValues.add(-8.833509227579786);
		companyValues.add(-1.5177069527743647);
		companyValues.add(7.635188960749513);
		companyValues.add(-1.6644578603528046);
		companyValues.add(9.103967846637122);
		companyValues.add(-4.410898448203557);
		companyValues.add(-8.613338041077519);
		companyValues.add(-6.0995299472256015);
		companyValues.add(6.645873460600193);
		companyValues.add(-2.3640741697156287);
		companyValues.add(4.658315960049187);
		companyValues.add(6.933747038600984);
		companyValues.add(3.9156383919181863);
		companyValues.add(1.208160735146933);
		companyValues.add(9.14166552197105);
		companyValues.add(9.271821337950005);
		companyValues.add(9.063525527017283);
		companyValues.add(-7.050238324107525);
		companyValues.add(0.8346476944314141);
		companyValues.add(4.793191123779817);
		companyValues.add(-7.5771635189720765);
		companyValues.add(-0.3907452578930748);
		companyValues.add(-3.5900962816233424);
		companyValues.add(4.647455269490653);
		companyValues.add(5.6763631264901875);
		companyValues.add(-9.6180895358863);
		companyValues.add(8.853868085553074);
		companyValues.add(9.170478223608587);
		companyValues.add(-0.4799795636155295);
		companyValues.add(-5.76088378982667);
		companyValues.add(3.9983603085585084);
		companyValues.add(8.327098673719195);
		companyValues.add(-2.763622926239977);
		companyValues.add(-2.856975942605975);
		companyValues.add(-8.695334469607271);
		companyValues.add(5.042349408998632);
		companyValues.add(6.141593421093834);
		companyValues.add(-8.123426662166167);
		companyValues.add(-5.376620934643251);
		companyValues.add(-6.073323125569143);
		companyValues.add(-5.954964446249978);
		companyValues.add(6.6760215420913624);
		companyValues.add(-8.358452096397633);
		companyValues.add(-8.329814760708773);
		companyValues.add(3.661645046307056);
		companyValues.add(-2.064848358947331);
		companyValues.add(4.341955556464336);
		companyValues.add(-5.224537993790794);
		companyValues.add(4.342891632972707);
		companyValues.add(-3.042653460518494);
		companyValues.add(7.037644967536242);
		companyValues.add(-4.681927052694492);
		companyValues.add(7.542953926358656);
		companyValues.add(-8.936232232427928);
		companyValues.add(-6.59191935113129);
		companyValues.add(-3.9316586156310773);
		companyValues.add(0.11251719720436704);
		companyValues.add(-4.677116638426058);
		companyValues.add(9.451621845359707);
		companyValues.add(-7.422436654205862);
		companyValues.add(-2.186610615651958);
		companyValues.add(-7.251350218791832);
		companyValues.add(-4.61774489337754);
		companyValues.add(-8.27365866909397);
		companyValues.add(-9.627101871925674);
		companyValues.add(8.021657371460943);
		companyValues.add(6.236829969355977);
		companyValues.add(-6.247757985907363);
		companyValues.add(-1.0521753426891944);
		companyValues.add(-7.380401266706906);
		companyValues.add(-1.677693947349507);
		companyValues.add(-2.081471182679775);
		companyValues.add(-2.956597342065976);
		companyValues.add(-2.299558295826447);
		companyValues.add(-3.379183075340335);
		companyValues.add(0.7552391002309182);
		companyValues.add(-3.2663030275790046);
		companyValues.add(-4.836278387894623);
		companyValues.add(-3.116375483098704);
		companyValues.add(0.19841186956368873);
		companyValues.add(-6.544540347195631);
		companyValues.add(-2.9776005669418666);
		companyValues.add(5.3833256238484335);
		companyValues.add(-1.0271948714864436);
		companyValues.add(-5.301666451106182);
		companyValues.add(-1.450237144595846);
		companyValues.add(-0.8430459035082798);
		companyValues.add(-3.7920310064035645);
		companyValues.add(-9.409933935664643);
		companyValues.add(-8.377118897526984);
		companyValues.add(0.06090080535457609);
		companyValues.add(7.5470749126631524);
		companyValues.add(-2.3238298946552565);
		companyValues.add(1.266151850922288);
		companyValues.add(-2.9281478146729683);
		companyValues.add(0.9024310999999372);
		companyValues.add(1.119248230635863);
		companyValues.add(-9.394490754983737);
		companyValues.add(3.006237612464634);
		companyValues.add(-2.468852886455073);
		companyValues.add(-4.906012367203005);
		companyValues.add(-2.7240990884971517);
		companyValues.add(-5.806050820514255);
		companyValues.add(6.248938586536944);
		companyValues.add(-3.670397027569874);
		companyValues.add(7.781665482747282);
		companyValues.add(-5.369615267560803);
		companyValues.add(-7.630398607444693);
		companyValues.add(1.5522914798960095);
		companyValues.add(5.391470702699273);
		companyValues.add(9.744134715443153);
		companyValues.add(-7.647798621554063);
		companyValues.add(-3.9939534083340833);
		companyValues.add(1.8565176420662954);
		companyValues.add(9.155939385718387);
		companyValues.add(-9.842418257226079);
		companyValues.add(-2.719043724651298);
		companyValues.add(3.5727317980707944);
		companyValues.add(2.6677884498076274);
		companyValues.add(-8.039713477490913);
		companyValues.add(-3.6461095825380774);
		companyValues.add(8.764700544563354);
		companyValues.add(9.209351860151632);
		companyValues.add(-7.868429815864086);
		companyValues.add(-3.952731964284961);
		companyValues.add(3.8511496217945975);
		companyValues.add(4.582187864910736);
		companyValues.add(-4.696343782701005);
		companyValues.add(6.0373744337864);
		companyValues.add(4.358779707862258);
		companyValues.add(-9.419535487746613);
		companyValues.add(6.844970613038949);
		companyValues.add(-6.905522702184987);
		companyValues.add(8.583310575978743);
		companyValues.add(-4.569785963807753);
		companyValues.add(7.220583706863675);
		companyValues.add(5.412777484743037);
		companyValues.add(0.653626072897449);
		companyValues.add(-6.5225852976592);
		companyValues.add(4.481637870489452);
		companyValues.add(-9.31099867059893);
		companyValues.add(-6.263076086133803);
		companyValues.add(0.6684805441521231);
		companyValues.add(-6.477928738640406);
		companyValues.add(9.034237827030239);
		companyValues.add(3.8298239881034757);
		companyValues.add(1.6050219661949718);
		companyValues.add(0.7604660077495566);
		companyValues.add(3.8543894063706823);
		companyValues.add(9.91241313300052);
		companyValues.add(-6.181987721736519);
		companyValues.add(-1.4506039672355069);
		companyValues.add(-3.489602391933393);
		companyValues.add(7.199231179223535);
		companyValues.add(-4.605210066816889);
		companyValues.add(-5.115830229491902);
		companyValues.add(-6.129818091399861);
		companyValues.add(-3.1967633350499725);
		companyValues.add(-6.79440291955566);
		companyValues.add(0.8774036878430422);
		companyValues.add(1.7900078705694167);
		companyValues.add(-2.664167544262151);
		companyValues.add(-9.285360729830284);
		companyValues.add(-9.01462120603327);
		companyValues.add(2.1137892926147845);
		companyValues.add(-8.201955367884883);
		companyValues.add(6.7239359324009484);
		companyValues.add(-0.883314409724953);
		companyValues.add(-4.045391592863046);
		companyValues.add(-3.425007975461507);
		companyValues.add(-0.6134935175091947);
		companyValues.add(-2.476829069727742);
		companyValues.add(1.8235093252130419);
		companyValues.add(-1.5721866146334111);
		companyValues.add(3.4387201478701);
		companyValues.add(4.767751536503869);
		companyValues.add(3.596418618586677);
		companyValues.add(-9.915756073322786);
		companyValues.add(-7.1600729135064505);
		companyValues.add(4.083171800278533);
		companyValues.add(-9.639184956241289);
		companyValues.add(5.361072788678312);
		companyValues.add(-4.1292478156350825);
		companyValues.add(4.080334264249588);
		companyValues.add(-2.140446747434794);
		companyValues.add(-9.291260674107171);
		companyValues.add(-4.770269018630491);
		companyValues.add(0.034341775662547036);
		companyValues.add(9.550035552549208);
		companyValues.add(-8.349644999508211);
		companyValues.add(1.7812437508579322);
		companyValues.add(-4.129057940418724);
		companyValues.add(4.222695748915054);
		companyValues.add(-0.20552190519589075);
		companyValues.add(-2.6540268458561407);
		companyValues.add(4.495578228436148);
		companyValues.add(6.673551243126564);
		companyValues.add(-1.067012384408537);
		companyValues.add(-0.7115860645179914);
		companyValues.add(-2.748207447750863);
		companyValues.add(8.101351263952768);
		companyValues.add(7.192446556718636);
		companyValues.add(7.644225310374576);
		companyValues.add(2.0652585752147594);
		companyValues.add(-6.299363574213503);
		companyValues.add(-3.7106393377137037);
		companyValues.add(-5.856493424443361);
		companyValues.add(-5.775756123840782);
		companyValues.add(6.347805692644023);
		companyValues.add(-1.353209233905531);
		companyValues.add(1.724356481807206);
		companyValues.add(3.7668443536923046);
		companyValues.add(7.328063956606631);
		companyValues.add(8.4617848052469);
		companyValues.add(2.9943604718677506);
		companyValues.add(-0.9101441623433857);
		companyValues.add(7.726911121702674);
		companyValues.add(3.7701461425238136);
		companyValues.add(-3.4140773098904837);
		companyValues.add(-2.336320541724053);
		companyValues.add(-2.589393513623084);
		companyValues.add(3.137074570130478);
		companyValues.add(1.4646530106131053);
		companyValues.add(1.632202483906319);
		companyValues.add(-7.5541680697852565);
		companyValues.add(2.8092515001710723);
		companyValues.add(0.9882917807806919);
		companyValues.add(-1.4039015490069282);
		companyValues.add(-3.6404452727938015);
		companyValues.add(-2.0040259106455967);
		companyValues.add(-9.123061274999102);
		companyValues.add(6.022561114445384);
		companyValues.add(5.815867351454287);
		companyValues.add(-4.59603037136106);
		companyValues.add(-1.7563665098625751);
		companyValues.add(-8.506023862526801);
		companyValues.add(7.0873764853402434);
		companyValues.add(-6.767444242116289);
		companyValues.add(2.4476184100863456);
		companyValues.add(-9.597396848490886);
		companyValues.add(6.124477410923227);
		companyValues.add(-0.4571558936773723);
		companyValues.add(2.7708926638328357);
		companyValues.add(7.717842519755887);
		companyValues.add(-7.9233546503728425);
		companyValues.add(0.2467136197300377);
		companyValues.add(2.7819503390559497);
		companyValues.add(-8.902786448667321);
		companyValues.add(-8.204354213336103);
		companyValues.add(-6.081688627017918);
		companyValues.add(-3.261125651293897);
		companyValues.add(-1.1183135818881063);
		companyValues.add(-8.84863945100874);
		companyValues.add(2.2128763605976136);
		companyValues.add(9.497240237625526);
		companyValues.add(-1.589441341398805);
		companyValues.add(-2.0833112255054616);
		companyValues.add(1.8846972955574373);
		companyValues.add(-1.8734337239890273);
		companyValues.add(-2.3894276793365066);
		companyValues.add(0.5287843351539543);
		companyValues.add(7.228068432896432);
		companyValues.add(-9.197673219832001);
		
		return companyValues;
	}
	
	@Test
	public void performApvCompanyValuation() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(2950.0);
		cashflows.add(2260.0);
		cashflows.add(2690.0);
		cashflows.add(4470.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(19000.0);
		liabilities.add(19500.0);
		liabilities.add(20000.0);
		liabilities.add(20500.0);
		
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		double corporateTax = 0.3;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithBallwieserData() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(138.61);
		cashflows.add(202.31);
		cashflows.add(174.41);
		cashflows.add(202.51);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithPohlData() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1569.18934438987, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithAllZeroAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(0, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performApvCompanyValuationWithAllOnesAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.248386764, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithAllBillionsAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1450000000.0);
		cashflows.add(1260000000.0);
		cashflows.add(3340000000.0);
		cashflows.add(1680000000.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1360000000.0);
		liabilities.add(1600000000.0);
		liabilities.add(2200000000.0);
		liabilities.add(1500000000.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(16504187818.2333000000, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithNegativAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(-520.13);
		cashflows.add(404.87);
		cashflows.add(-203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(-1260.0);
		liabilities.add(-1300.0);
		liabilities.add(1000.0);
		liabilities.add(-1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(-601.6495353431, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithSmallAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.12);
		cashflows.add(0.78);
		cashflows.add(0.56);
		cashflows.add(1.01);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.34);
		liabilities.add(1.2);
		liabilities.add(0.8);
		liabilities.add(0.51);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.4465325137, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithDifferentTaxRates() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		
		double equityInterest = 0.080722;
		double outsideCapitalInterest = 0.06;
		double corporateTax = 0.349;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(2146.60456861283, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithThreePeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(404.8692500000);
		cashflows.add(203.7832500000);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1300.00);
		liabilities.add(1400.00);

		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1335.2312081890, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	public void performApvCompanyValuationWithTenPeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(3960.0);
		cashflows.add(4158.0);
		cashflows.add(4365.0);
		cashflows.add(4584.0);
		cashflows.add(4813.0);
		cashflows.add(5054.0);
		cashflows.add(4587.0);
		cashflows.add(5035.0);
		cashflows.add(4035.0);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1625.0);
		liabilities.add(1771.0);
		liabilities.add(1931.0);
		liabilities.add(2104.0);
		liabilities.add(2294.0);
		liabilities.add(2500.0);
		liabilities.add(1850.0);
		liabilities.add(2300.0);
		liabilities.add(2468.0);
		
		
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		ApvCompanyValuationResultDto apvCompanyValuationResult = valuationService.performApvCompanyValuation(cashflows,
				liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(41640.17149257649, apvCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuation() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(2950.0);
		cashflows.add(2260.0);
		cashflows.add(2690.0);
		cashflows.add(4470.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(19000.0);
		liabilities.add(19500.0);
		liabilities.add(20000.0);
		liabilities.add(20500.0);
		
		double corporateTax = 0.3;
		double equityInterest = 0.09;
		double outsideCapitalInterest = 0.05;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(32146.0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	@Test
	public void performFcfCompanyValuationwithBallwieserData() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(138.61);
		cashflows.add(202.31);
		cashflows.add(174.41);
		cashflows.add(202.51);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithPohlData() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1569.18934438987,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllZeroAmounts() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(0,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllOnesAmounts() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		cashflows.add(1.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.248386764,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationwithAllBillionsAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1450000000.0);
		cashflows.add(1260000000.0);
		cashflows.add(3340000000.0);
		cashflows.add(1680000000.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1360000000.0);
		liabilities.add(1600000000.0);
		liabilities.add(2200000000.0);
		liabilities.add(1500000000.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(16504187818.2333000000,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}

	@Test
	public void performFcfCompanyValuationwithNegativAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(-520.13);
		cashflows.add(404.87);
		cashflows.add(-203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(-1260.0);
		liabilities.add(-1300.0);
		liabilities.add(1000.0);
		liabilities.add(-1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(-601.6495353431,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithSmallAmounts() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.12);
		cashflows.add(0.78);
		cashflows.add(0.56);
		cashflows.add(1.01);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.34);
		liabilities.add(1.2);
		liabilities.add(0.8);
		liabilities.add(0.51);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.4465325137,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithDifferentTaxRates() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(176.76);
		cashflows.add(520.13);
		cashflows.add(404.87);
		cashflows.add(203.78);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		
		double equityInterest = 0.080722;
		double outsideCapitalInterest = 0.06;
		double corporateTax = 0.349;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(2146.60456861283,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithThreePeriods() {

		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(404.8692500000);
		cashflows.add(203.7832500000);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1300.00);
		liabilities.add(1400.00);

		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1335.2312081890,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void performFcfCompanyValuationWithTenPeriods() {
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(3960.0);
		cashflows.add(4158.0);
		cashflows.add(4365.0);
		cashflows.add(4584.0);
		cashflows.add(4813.0);
		cashflows.add(5054.0);
		cashflows.add(4587.0);
		cashflows.add(5035.0);
		cashflows.add(4035.0);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1625.0);
		liabilities.add(1771.0);
		liabilities.add(1931.0);
		liabilities.add(2104.0);
		liabilities.add(2294.0);
		liabilities.add(2500.0);
		liabilities.add(1850.0);
		liabilities.add(2300.0);
		liabilities.add(2468.0);
		
		
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;
		
		CompanyValuationService valuationService = new CompanyValuationService();

		FcfCompanyValuationResultDto fcfCompanyValuationResult = valuationService.performFcfCompanyValuationResult(cashflows, liabilities, equityInterest,
				outsideCapitalInterest, corporateTax);

		Assert.assertEquals(41640.17149257649,fcfCompanyValuationResult.getCompanyValue(), 0.1);
	}
	@Test
	public void performFteCompanyValuation() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(124.34);
		cashflows.add(134.51);
		cashflows.add(166.02);
		cashflows.add(120.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithBallwieserData() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(124.3456);
		cashflows.add(134.50919999999996);
		cashflows.add(166.0198);
		cashflows.add(119.994);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1320.0);
		liabilities.add(1330.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.09969137;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.26325;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1055.24, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithPohlData() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(146.82999999999998);
		cashflows.add(147.98000000000002);
		cashflows.add(749.37);
		cashflows.add(126.08000000000001);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1569.18934438987, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithAllZeroAmounts() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		cashflows.add(0.0);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		liabilities.add(0.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(0.0, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithAllOnesAmounts() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(0.9445);
		cashflows.add(0.9445);
		cashflows.add(0.9445);
		cashflows.add(0.9445);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);
		liabilities.add(1.0);

		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.248386764, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithAllBillionsAmounts() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.61452E9);
		cashflows.add(1.7712E9);
		cashflows.add(2.5179E9);
		cashflows.add(1.59675E9);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1360000000.0);
		liabilities.add(1600000000.0);
		liabilities.add(2200000000.0);
		liabilities.add(1500000000.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(16504187818.2333000000, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithNegativAmounts() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(206.69);
		cashflows.add(1852.02);
		cashflows.add(-2050.63);
		cashflows.add(-126.08000000000001);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(-1260.0);
		liabilities.add(-1300.0);
		liabilities.add(1000.0);
		liabilities.add(-1400.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(-601.6495353431, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithSmallAmounts() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(1.9611299999999998);
		cashflows.add(0.3134000000000001);
		cashflows.add(0.22560000000000002);
		cashflows.add(0.981695);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(0.34);
		liabilities.add(1.2);
		liabilities.add(0.8);
		liabilities.add(0.51);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(9.4465325137, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithDifferentTaxRate() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(167.5444);
		cashflows.add(169.35199999999998);
		cashflows.add(765.81);
		cashflows.add(149.096);
		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1260.0);
		liabilities.add(1300.0);
		liabilities.add(1000.0);
		liabilities.add(1400.0);
		
		
		double equityInterest = 0.080722;
		double outsideCapitalInterest = 0.06;
		double corporateTax = 0.349;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(2146.60456861283, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithThreePeriods() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(432.71925000000005);
		cashflows.add(126.08325000000002);

		
		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1300.00);
		liabilities.add(1400.00);

		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(1335.2312081890, fteCompanyValuationResult.getCompanyValue(), 0.1);

	}
	
	@Test
	public void performFteCompanyValuationWithTenPeriods() {
		
		List<Double> cashflows = new ArrayList<Double>();
		cashflows.add(4015.8125);
		cashflows.add(4219.709500000001);
		cashflows.add(4430.829500000001);
		cashflows.add(4657.228);
		cashflows.add(4891.683);
		cashflows.add(4265.25);
		cashflows.add(4934.325);
		cashflows.add(5075.35);
		cashflows.add(3898.026);

		List<Double> liabilities = new ArrayList<Double>();
		liabilities.add(1625.0);
		liabilities.add(1771.0);
		liabilities.add(1931.0);
		liabilities.add(2104.0);
		liabilities.add(2294.0);
		liabilities.add(2500.0);
		liabilities.add(1850.0);
		liabilities.add(2300.0);
		liabilities.add(2468.0);
		
		double equityInterest = 0.100582;
		double outsideCapitalInterest = 0.08;
		double corporateTax = 0.30625;

		CompanyValuationService valuationService = new CompanyValuationService();
		FteCompanyValuationResultDto fteCompanyValuationResult = valuationService.performFteCompanyValuationResult(
				cashflows, liabilities, equityInterest, outsideCapitalInterest, corporateTax);

		Assert.assertEquals(41640.17149257649, fteCompanyValuationResult.getCompanyValue(), 0.1);
	}
	
	@Test
	public void getCompanyValuDistribution_smallRange_correctDistribution() {
		//Arrange
		CompanyValuationService companyValuationService = new CompanyValuationService();
		List<Double> companyValues = getSmallCompanyValuesRange();
		
		List<Double> expectedXValues = new ArrayList<>();
		expectedXValues.add(-17.63560964);
		expectedXValues.add(-16.48974353);
		expectedXValues.add(-15.34387743);
		expectedXValues.add(-14.19801132);
		expectedXValues.add(-13.05214522);
		expectedXValues.add(-11.90627912);
		expectedXValues.add(-10.76041301);
		expectedXValues.add(-9.614546908);
		expectedXValues.add(-8.468680804);
		expectedXValues.add(-7.3228147);
		expectedXValues.add(-6.176948597);
		expectedXValues.add(-5.031082493);
		expectedXValues.add(-3.885216389);
		expectedXValues.add(-2.739350285);
		expectedXValues.add(-1.593484181);
		expectedXValues.add(-0.447618077);
		expectedXValues.add(0.698248027);
		expectedXValues.add(1.844114131);
		expectedXValues.add(2.989980234);
		expectedXValues.add(4.135846338);
		expectedXValues.add(5.281712442);
		expectedXValues.add(6.427578546);
		expectedXValues.add(7.57344465);
		expectedXValues.add(8.719310754);
		expectedXValues.add(9.865176858);
		expectedXValues.add(11.01104296);
		expectedXValues.add(12.15690907);
		expectedXValues.add(13.30277517);
		expectedXValues.add(14.44864127);
		expectedXValues.add(15.59450738);
		expectedXValues.add(16.74037348);
		
		List<Double> expectedYValues = new ArrayList<>();
		expectedYValues.add(0.000773536872576772000000);
		expectedYValues.add(0.001381566582024340000000);
		expectedYValues.add(0.002370777735319040000000);
		expectedYValues.add(0.003908751680322790000000);
		expectedYValues.add(0.006191751850602790000000);
		expectedYValues.add(0.009423608278547980000000);
		expectedYValues.add(0.013779997162585500000000);
		expectedYValues.add(0.019360173811547600000000);
		expectedYValues.add(0.026133501135719900000000);
		expectedYValues.add(0.033893323892829200000000);
		expectedYValues.add(0.042233682225115800000000);
		expectedYValues.add(0.050562897668477600000000);
		expectedYValues.add(0.058161176382349000000000);
		expectedYValues.add(0.064278040698840300000000);
		expectedYValues.add(0.068252772754358600000000);
		expectedYValues.add(0.069631570224538300000000);
		expectedYValues.add(0.068252772754358600000000);
		expectedYValues.add(0.064278040698840300000000);
		expectedYValues.add(0.058161176382349000000000);
		expectedYValues.add(0.050562897668477600000000);
		expectedYValues.add(0.042233682225115800000000);
		expectedYValues.add(0.033893323892829200000000);
		expectedYValues.add(0.026133501135719900000000);
		expectedYValues.add(0.019360173811547600000000);
		expectedYValues.add(0.013779997162585500000000);
		expectedYValues.add(0.009423608278547980000000);
		expectedYValues.add(0.006191751850602790000000);
		expectedYValues.add(0.003908751680322790000000);
		expectedYValues.add(0.002370777735319040000000);
		expectedYValues.add(0.001381566582024300000000);
		expectedYValues.add(0.000773536872576750000000);
		
		//Act
		CompanyValueDistributionDto distribution = companyValuationService.getCompanyValueDistribution(companyValues);
		
		//Assert
		for(int i = 0; i < distribution.getxValues().size(); i++) {
			assertEquals(expectedXValues.get(i).doubleValue(), distribution.getxValues().get(i).doubleValue(), 1E10);
			assertEquals(expectedYValues.get(i).doubleValue(), distribution.getyValues().get(i).doubleValue(), 1E10);
		}
	}
	
	@Test
	public void getCompanyValuDistribution_largeRange_correctDistribution() {
		//Arrange
		CompanyValuationService companyValuationService = new CompanyValuationService();
		List<Double> companyValues = getLargeCompanyValuesRange();
		
		List<Double> expectedXValues = new ArrayList<>();
		expectedXValues.add(-1691508.062);
		expectedXValues.add(-1578318.29);
		expectedXValues.add(-1465128.518);
		expectedXValues.add(-1351938.746);
		expectedXValues.add(-1238748.974);
		expectedXValues.add(-1125559.202);
		expectedXValues.add(-1012369.43);
		expectedXValues.add(-899179.6578);
		expectedXValues.add(-785989.8857);
		expectedXValues.add(-672800.1136);
		expectedXValues.add(-559610.3415);
		expectedXValues.add(-446420.5695);
		expectedXValues.add(-333230.7974);
		expectedXValues.add(-220041.0253);
		expectedXValues.add(-106851.2532);
		expectedXValues.add(6338.518848);
		expectedXValues.add(119528.2909);
		expectedXValues.add(232718.063);
		expectedXValues.add(345907.8351);
		expectedXValues.add(459097.6072);
		expectedXValues.add(572287.3792);
		expectedXValues.add(685477.1513);
		expectedXValues.add(798666.9234);
		expectedXValues.add(911856.6955);
		expectedXValues.add(1025046.468);
		expectedXValues.add(1138236.24);
		expectedXValues.add(1251426.012);
		expectedXValues.add(1364615.784);
		expectedXValues.add(1477805.556);
		expectedXValues.add(1590995.328);
		expectedXValues.add(1704185.1);
		
		List<Double> expectedYValues = new ArrayList<>();
		expectedYValues.add(0.000000007830828405412890);
		expectedYValues.add(0.000000013986160476676700);
		expectedYValues.add(0.000000024000347353595900);
		expectedYValues.add(0.000000039569883186065100);
		expectedYValues.add(0.000000062681622544316300);
		expectedYValues.add(0.000000095399019756247700);
		expectedYValues.add(0.000000139500516436692000);
		expectedYValues.add(0.000000195990914450108000);
		expectedYValues.add(0.000000264560062075353000);
		expectedYValues.add(0.000000343115904235689000);
		expectedYValues.add(0.000000427548744162540000);
		expectedYValues.add(0.000000511868780092318000);
		expectedYValues.add(0.000000588789246193206000);
		expectedYValues.add(0.000000650712751768413000);
		expectedYValues.add(0.000000690950581130800000);
		expectedYValues.add(0.000000704908708761908000);
		expectedYValues.add(0.000000690950581130800000);
		expectedYValues.add(0.000000650712751768413000);
		expectedYValues.add(0.000000588789246193206000);
		expectedYValues.add(0.000000511868780092318000);
		expectedYValues.add(0.000000427548744162540000);
		expectedYValues.add(0.000000343115904235689000);
		expectedYValues.add(0.000000264560062075353000);
		expectedYValues.add(0.000000195990914450108000);
		expectedYValues.add(0.000000139500516436692000);
		expectedYValues.add(0.000000095399019756247700);
		expectedYValues.add(0.000000062681622544316300);
		expectedYValues.add(0.000000039569883186065100);
		expectedYValues.add(0.000000024000347353595900);
		expectedYValues.add(0.000000013986160476676300);
		expectedYValues.add(0.000000007830828405412650);
		
		//Act
		CompanyValueDistributionDto distribution = companyValuationService.getCompanyValueDistribution(companyValues);
		
		//Assert
		for(int i = 0; i < distribution.getxValues().size(); i++) {
			assertEquals(expectedXValues.get(i).doubleValue(), distribution.getxValues().get(i).doubleValue(), 1E10);
			assertEquals(expectedYValues.get(i).doubleValue(), distribution.getyValues().get(i).doubleValue(), 1E10);
		}
	}
}
