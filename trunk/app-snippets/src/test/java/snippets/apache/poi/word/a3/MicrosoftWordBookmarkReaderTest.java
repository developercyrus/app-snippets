package snippets.apache.poi.word.a3;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class MicrosoftWordBookmarkReaderTest {
    @Test
    public void test() throws FileNotFoundException, IOException {
        MicrosoftWordBookmarkReader r = new MicrosoftWordBookmarkReader();
        assertEquals("hdr_co_enm", r.getBkmkList().get(0));
        assertEquals("corr_addr_ln1", r.getBkmkList().get(1));
        assertEquals("corr_addr_ln2", r.getBkmkList().get(2));
        assertEquals("corr_addr_ln3", r.getBkmkList().get(3));
        assertEquals("corr_addr_ln4", r.getBkmkList().get(4));
        assertEquals("isd_co_enm", r.getBkmkList().get(5));
        assertEquals("ins_id_desc_passport_no", r.getBkmkList().get(6));
        assertEquals("ins_birth_dd", r.getBkmkList().get(7));
        assertEquals("ins_gender_desc", r.getBkmkList().get(8));
        assertEquals("isd_smoker_fl_desc", r.getBkmkList().get(9));
        assertEquals("poy_eff_dd", r.getBkmkList().get(10));
        assertEquals("poy_exp_dd", r.getBkmkList().get(11));
        assertEquals("cur_enm", r.getBkmkList().get(12));
        assertEquals("sum_assur_pc_fmt", r.getBkmkList().get(13));
        assertEquals("TPD_sum_assur_pc_fmt", r.getBkmkList().get(14));
        assertEquals("poy_prem_pc_fmt", r.getBkmkList().get(15));
        assertEquals("TPD_poy_prem_pc_fmt", r.getBkmkList().get(16));
        assertEquals("indexation_desc", r.getBkmkList().get(17));
        assertEquals("pay_mod_enm", r.getBkmkList().get(18));
        assertEquals("tot_modal_prem_fmt", r.getBkmkList().get(19));
        assertEquals("prem_due_dd_enm", r.getBkmkList().get(20));
        assertEquals("prem_due_enm", r.getBkmkList().get(21));
        assertEquals("add_cv", r.getBkmkList().get(22));
        assertEquals("sp_cond_nil", r.getBkmkList().get(23));
        assertEquals("maj_exclu", r.getBkmkList().get(24));
        assertEquals("REPEAT_H04", r.getBkmkList().get(25));
        assertEquals("ldg_prod_enm", r.getBkmkList().get(26));
        assertEquals("ldg_prod_ldg_desc_enm", r.getBkmkList().get(27));
        assertEquals("ldg_prod_ldg_ratio", r.getBkmkList().get(28));
        assertEquals("prem_due_onm", r.getBkmkList().get(29));
        assertEquals("REPEAT_F04", r.getBkmkList().get(30));
        assertEquals("poy_issue_dd", r.getBkmkList().get(31));
        assertEquals("REPEAT_H01", r.getBkmkList().get(32));
        assertEquals("poy_no", r.getBkmkList().get(33));
    }
    
    @Test
    public void testCount() throws FileNotFoundException, IOException {
        MicrosoftWordBookmarkReader r = new MicrosoftWordBookmarkReader();
        assertEquals(34, r.getBkmkCount());
    }
}
