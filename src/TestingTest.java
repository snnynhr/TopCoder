import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class TestingTest {
	public static ArrayList<String> num = new ArrayList<String>();
	static BigInteger MOD = new BigInteger("599283023552414275838685063377325868111900");
	//48 keys
	static BigInteger[][] keys = {
		{new BigInteger("116"), new BigInteger("5340342343456180831716311918824435227733")},
		{new BigInteger("68"),	new BigInteger("4694834529111866497642094185471120980099")},
		{new BigInteger("47"),	new BigInteger("2985558448356350949342309936054043944717")},
		{new BigInteger("109"), new BigInteger("1924442166563347280190854585251876135818")},
		{new BigInteger("62"), new BigInteger("748595560968274268300719321058251857908")},
		{new BigInteger("25"),	new BigInteger("3726790694526994731286288457224202585450")},
		{new BigInteger("79"),	new BigInteger("2048230071713270354249199930501256851462")},
		{new BigInteger("8"), new BigInteger("5327131394704077116476117334104026493182")},
		{new BigInteger("111"), new BigInteger("3080335949645119178852125329439258895211")},
		{new BigInteger("107"), new BigInteger("2648025329166058715617847942200476539559")},
		{new BigInteger("104"), new BigInteger("5936958858466307424729425256233373932572")},
		{new BigInteger("80"),	new BigInteger("4549544863191746965234110952607268201560")},
		{new BigInteger("39"),	new BigInteger("3712674476053764452392069862783944354556")},
		{new BigInteger("6"), new BigInteger("123666423930744881600856641172365180327")},
		{new BigInteger("20"),	new BigInteger("926512713765690765728997985916608045763")},
		{new BigInteger("74"),	new BigInteger("5652379616125941885220848029716944416202")},
		{new BigInteger("22"),	new BigInteger("175507113958897787684190402134101244385")},
		{new BigInteger("60"),	new BigInteger("2582465586602346488322897952751917694303")},
		{new BigInteger("123"), new BigInteger("2343829696209227624322070496419466023255")},
		{new BigInteger("122"), new BigInteger("3906051657884246799019883186022193706812")},
		{new BigInteger("84"),	new BigInteger("5754331978660458893728548534389534212154")},
		{new BigInteger("45"),	new BigInteger("634631395484254837315244283813330885421")},
		{new BigInteger("82"),	new BigInteger("2579039184783884807831498466214156342511")},
		{new BigInteger("50"),	new BigInteger("992880077920524070271584950241410743815")},
		{new BigInteger("46"),	new BigInteger("3119324834521819233239017338249153949331")},
		{new BigInteger("90"),	new BigInteger("281198918555342220115405296538523288158")},
		{new BigInteger("98"),	new BigInteger("1665054211162672858736249406489625667486")},
		{new BigInteger("18"),	new BigInteger("4122706208699593069725931657207051967859")},
		{new BigInteger("35"),	new BigInteger("4237838398266290032100245253199216851633")},
		{new BigInteger("43"),	new BigInteger("4678454530417605467148161334556501668529")},
		{new BigInteger("42"),	new BigInteger("4924539322602493952861185511434016885184")},
		{new BigInteger("119"), new BigInteger("2550699916229382621776498851764701834340")},
		{new BigInteger("11"),	new BigInteger("482661954833713285543424169166975132456")},
		{new BigInteger("100"), new BigInteger("5017069663058394597085627304311221122721")},
		{new BigInteger("58"),	new BigInteger("4601962930416346546910405470490268757682")},
		{new BigInteger("52"),	new BigInteger("2295429747322351327034409070674150291713")},
		{new BigInteger("70"),	new BigInteger("5682295235124786027749090055933565647960")},
		{new BigInteger("26"),	new BigInteger("5707081319541254039821169637343740140021")},
		{new BigInteger("37"),	new BigInteger("4205494807514215091234122807962665358979")},
		{new BigInteger("53"), new BigInteger("4367124535114794649711193499883811173355")},
		{new BigInteger("102"), new BigInteger("2250429729464354079602289139406979459204")},
		{new BigInteger("118"), new BigInteger("380726718802077528318326723472012588113")},
		{new BigInteger("16"), new BigInteger("3816236757578622817111897124260290399034")},
		{new BigInteger("12"), new BigInteger("5276923723565969838080497264715234091920")},
		{new BigInteger("124"), new BigInteger("3910132994755044528036690918199088474818")},
		{new BigInteger("14"), new BigInteger("5702216094551507724238175950574204513588")},
		{new BigInteger("3"), new BigInteger("1281058994896129245568435469022115063016")},
		{new BigInteger("67"), new BigInteger("2856319160962810161566152130854149238290")},
		{new BigInteger("31"), new BigInteger("2619106226196841071943963910113222583225")},
		{new BigInteger("106"), new BigInteger("3737531756890675423364052498892548274608")}};
	public static void main(String args[])
	{
		BigDecimal result = shamirLagrangeInterpolation1();
		System.out.println("RESULT: "+result.toString());

	}
	public static BigInteger shamirLagrangeInterpolation()
	{
		BigInteger FINAL = BigInteger.ZERO;
		for(int i=0; i<keys.length; i++)
		{
			BigInteger res = new BigInteger("1");
			BigInteger curr = keys[i][0];
			for(int j=0; j<keys.length; j++)
				if(i!=j) res = res.multiply(keys[j][0]);
			res = res.negate();
			res = res.multiply(keys[i][1]);
			for(int j=0; j<keys.length; j++)
			{
				BigInteger cc = curr.negate().negate();
				if(i!=j)
				{
					res=res.divide(cc.subtract(keys[j][0]));
				}
			}
			//System.out.println(res.toString());
			res=res.remainder(MOD);
			res = res.add(MOD);
			res=res.remainder(MOD);
			System.out.println(res.toString());
			FINAL = FINAL.add(res);
			FINAL = FINAL.remainder(MOD);
		}
		return FINAL;
	}
	public static BigDecimal shamirLagrangeInterpolation1()
	{
		BigDecimal FINAL = BigDecimal.ZERO;
		for(int i=0; i<keys.length; i++)
		{
			BigDecimal res = new BigDecimal("1.0");
			BigInteger curr = keys[i][0];
			for(int j=0; j<keys.length; j++)
				if(i!=j) res = res.multiply(new BigDecimal(keys[j][0]));
			res = res.negate();
			System.out.println(res.toPlainString());
			//Double rr = res.doubleValue();
			//System.out.println(rr.);
			res = res.multiply(new BigDecimal(keys[i][1]));
			for(int j=0; j<keys.length; j++)
			{
				BigInteger cc = curr.negate().negate();
				if(i!=j)
				{
					res=res.divide(new BigDecimal(cc.subtract(keys[j][0])),7,BigDecimal.ROUND_HALF_UP);
				}
			}
			//System.out.println(res.toString());
			res=res.remainder(new BigDecimal(MOD));
			res = res.add(new BigDecimal(MOD));
			res=res.remainder(new BigDecimal(MOD));
			System.out.println(res.toString());
			FINAL = FINAL.add(res);
			FINAL = FINAL.remainder(new BigDecimal(MOD));
		}
		return FINAL;
	}





	public static void main1(String args[])
	{
		int max = 0;
		dfs(0,13,"");;

		for(int i=0; i<num.size(); i++)
		{
			//System.out.println(num.get(i));
			String res = f(num.get(i));
			//System.out.println(res.length());
			max = Math.max(max, res.length());
		}
		//System.out.println(f("aba"));
		System.out.println("max: "+max);
	}
	public static void dfs(int i, int n, String s)
	{
		if(i==n) num.add(s);
		else
		{
			dfs(i+1,n,s+"a");
			dfs(i+1,n,s+"b");
		}
	}
	public static String f(String s)
	{
		if(s.length()==1) return s;
		else if(s.length()>2&&s.substring(s.length()-2).equals("ba"))
		{

			return f("ab"+f(D(s.substring(0,s.length()-2)+"ba"))+"b");
		}
		else if(s.charAt(0)=='b'&&s.length()>1)
		{
			return f(s.substring(1))+"b";
		}
		else if(s.length()>2&&s.charAt(0)=='a'&& s.charAt(s.length()-1)=='a')
		{
			return "a"+f("a"+D("a"+s.substring(1,s.length()-1)));
		}
		else if(s.length()>1&&s.charAt(0)=='a')
			return "a"+f(s.substring(1))+"a";
		else return s;

	}
	public static String D(String s)
	{
		if(s.length()<3) return "";
		else return s.substring(2);
	}
}
