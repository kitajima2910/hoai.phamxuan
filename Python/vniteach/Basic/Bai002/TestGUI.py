import sys

from PyQt6.QtCore import pyqtSlot
from PyQt6.QtWidgets import QDialog, QApplication
from PyQt6.uic import loadUi


class TestGUI(QDialog):
    def __init__(self):
        super(TestGUI, self).__init__()
        loadUi('./GUI/test_gui.ui', self)

        self.init_ui()

        self.btnPress.clicked.connect(self.load_clicked)

    @pyqtSlot()
    def load_clicked(self):
        self.txtContent.setText('Hello Worl!')

    def init_ui(self):
        self.setFixedSize(self.size())  # Set the dialog size as fixed


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = TestGUI()
    window.show()

    try:
        sys.exit(app.exec())
    except None:
        print('Exit')
