package in.tp.jd;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("in.tp.jd.service")
@IncludeTags("ptest")
public class AllPTests {

}
