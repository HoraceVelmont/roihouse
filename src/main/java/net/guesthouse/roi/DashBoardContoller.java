package net.guesthouse.roi;

import java.util.List;

import net.guesthouse.roi.dao.ReserveDao;
import net.guesthouse.roi.dao.ReserverDao;
import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.RContainer;
import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.dto.model.ReserverModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashBoardContoller {

	@Autowired
	ReserveDao reserveDao;
	@Autowired
	ReserverDao reserverDao;

	private static Logger LOGGER = LoggerFactory
			.getLogger(DashBoardContoller.class);

	@RequestMapping(value = "/dashboard.roi", method = RequestMethod.GET)
	public String dashBoard(Model model) {

		return "dashboard";
	}

	@RequestMapping(value = "/inputform.roi", method = RequestMethod.GET)
	public String inputform(Model model) {

		return "inputform";
	}

	@RequestMapping(value = "/selectReserveList.roi", method = RequestMethod.POST)
	public @ResponseBody
	Object selectReserveList(@RequestBody DashboardTimeModel timeModel) {
		
		List<ReserveModel> reserveModels = reserveDao
				.selectReserveList(timeModel);
		if (reserveModels.size() != 0) {
			return reserveModels;
		} else {
			return "{err : empty}";

		}
	}

	@RequestMapping(value = "/postInputForm.roi", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody
	Object postInputForm(@RequestBody RContainer value) {
		LOGGER.debug("reserverModel : {}, reserveModel : {}",
				value.getReserverModel(), value.getReserveModel());
		int result = reserverDao.insertReserver(value.getReserverModel());
		if (result < 0) {
			return false;
		}
		value.getReserveModel().setReserver(value.getReserverModel().getId());
		result = reserveDao.insertReserve(value.getReserveModel());

		if (result < 0) {
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/insertReserve.roi", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody
	Object insertReserve(@RequestBody ReserveModel reserveModel) {
		int result = reserveDao.insertReserve(reserveModel);

		if (result < 0) {
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/insertReserver.roi", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody
	Object insertReserver(@RequestBody ReserverModel reserverModel) {
		LOGGER.info("reserverModel : {}", reserverModel.toString());

		System.out.println("test");
		int result = reserverDao.insertReserver(reserverModel);

		if (result < 0) {
			return false;
		}
		return true;
	}
}
