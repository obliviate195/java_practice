#include "come_on.h"

int main(void)
{
	ble_start();

	// lcd
	lcd_init();
	//draw_rectangle(0x0A, 0x30, 0x28, 0x40);
	//draw_rectangle(5, 80, 20, 125);
	//draw_rectangle(0, 0, 10, 10);
	draw_hp(1, 48);
	draw_hp(2, 48);
	
	draw_circle(0, 1);
	draw_circle(1, 0);
	draw_circle(2, 0);
	draw_circle(3, 1);

	//draw_go();
	draw_ready();
	//exer1();
	// Enter main loop.
	while(1) {
		if (NRF_LOG_PROCESS() == false) {
			power_manage();
		}
	}
}
