<%-- 
    Document   : Home
    Created on : Feb 21, 2022, 9:47:14 AM
    Author     : 84915
--%>

<%@page import="model.Customers"%>
<%@page import="model.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Apartment Management</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <style>
            select[readonly]{
                pointer-events: none;
                touch-action: none;
            }
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }
        </style>

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="QLCanHo.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">QUẢN LÝ CHUNG CƯ</div>
                </a>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Thêm Dữ Liệu</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="EditKH.jsp">Khách Hàng</a>
                            <a class="collapse-item" href="EditDV.jsp">Dịch Vụ</a>
                            <a class="collapse-item" href="EditCH.jsp">Căn hộ</a>
                            <a class="collapse-item" href="EditHÐ.jsp">Hoá Đơn</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
                       aria-expanded="true" aria-controls="collapsePages">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Quản Lý</span>
                    </a>
                    <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Dịch Vụ:</h6>
                            <a class="collapse-item" href="QLDichVu.jsp">Quản lí Dịch vụ</a>
                            <div class="collapse-divider"></div>
                            <h6 class="collapse-header">Căn hộ:</h6>
                            <a class="collapse-item" href=QLCanHo.jsp>Quản lý căn hộ</a>
                            <a class="collapse-item" href="QLHoaDon.jsp">Hóa đơn</a>
                            <div class="collapse-divider"></div>
                            <h6 class="collapse-header">Khách Hàng:</h6>
                            <a class="collapse-item" href="QLKhachHang.jsp">Khách hàng</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <form class="form-inline">
                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                <i class="fa fa-bars"></i>
                            </button>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("username")%></span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Đăng Xuất
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">QUẢN LÝ CHUNG CƯ</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <form action="CRUD" method="GET">
                                        <input type="hidden" name="manage" value="Apartment">
                                        <%
                                            String type = "";
                                            try {
                                                type = request.getAttribute("type").toString();
                                            } catch (Exception e) {
                                                type = "add";
                                            }
                                            if (type == "edit") {
                                                ArrayList<Apartment> listApartmentByID = DAO.Home.getApartmentByID(Integer.parseInt(request.getAttribute("id").toString()));
                                                for (Apartment dtoApartment : listApartmentByID) {
                                        %>
                                        <h3 class="mb-5">Thay đổi thông tin</h3>
                                        <div class="form-outline mb-4">
                                            <h6 class="m-0 font-weight-bold text-primary">Mã phòng</h6>
                                            <select name="id" class="form-control form-control-lg" readonly>
                                                <option value="<%=  dtoApartment.getIdPhong()%>"><%=  dtoApartment.getIdPhong()%></option>
                                            </select>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Người thuê</h6>
                                        <div class="form-outline mb-4">
                                            <select name="idKH" class="form-control form-control-lg"  id="gender">
                                                <%
                                                    ArrayList<Customers> listCustomers = DAO.Home.getCustomers();
                                                    for (Customers dtoCustomers : listCustomers) {
                                                        if (dtoCustomers.getIdKH() == dtoApartment.getIdKH()) {
                                                %>
                                                <option value="<%= dtoCustomers.getIdKH()%>" selected><%= dtoCustomers.getTenKH()%></option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%= dtoCustomers.getIdKH()%>"><%= dtoCustomers.getTenKH()%></option>
                                                <%
                                                        }
                                                    }
                                                    if (dtoApartment.getIdKH() >= 1) {
                                                %>
                                                <option value="0">Trống</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="0" selected>Trống</option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Tháng thuê</h6>
                                        <div class="form-outline mb-4">
                                            <select name="ThangThue" class="form-control form-control-lg"  id="Thangthue">
                                                <%
                                                    if (dtoApartment.getThangThue() == 0) {
                                                %>
                                                <option value="0" selected>Trống</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="0">Trống</option>
                                                <%
                                                    }
                                                    for (int i = 1; i <= 12; i++) {
                                                        if (i == dtoApartment.getThangThue()) {
                                                %>
                                                <option value="<%= i%>" selected><%= i%></option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%= i%>"><%= i%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Giá thuê</h6>
                                        <div class="form-outline mb-4">
                                            <input name="GiaThue" type="text" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Giá Thuê" value="<%=String.format("%.0f", dtoApartment.getGiaThue()) %>" required pattern="^[1-9]+[0-9]*$" title="Giá Tiền phải là số dương"/>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Trạng Thái</h6>
                                        <div class="form-outline mb-4">
                                            <select name="trangThai" class="form-control form-control-lg"  id="gender">
                                                <%
                                                    if (dtoApartment.getTrangThai() == 1) {
                                                %>
                                                <option value="1" selected>Được Thuê</option>
                                                <option value="2">Trống</option>
                                                <option value="3">Đang sửa chữa</option>
                                                <%
                                                } else if (dtoApartment.getTrangThai() == 2) {
                                                %>
                                                <option value="1">Được Thuê</option>
                                                <option value="2" selected>Trống</option>
                                                <option value="3">Đang sửa chữa</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="1">Được Thuê</option>
                                                <option value="2">Trống</option>
                                                <option value="3" selected>Đang sửa chữa</option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>

                                        <%
                                            }
                                        %>
                                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="type" value="ApplyEdit">Thay đổi</button>
                                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="type" value="Cancel">Huỷ</button>
                                        <%
                                        } else {
                                        %>
                                        <h3 class="mb-5">Thêm Căn hộ</h3>
                                        <h6 class="m-0 font-weight-bold text-primary">Người thuê</h6>
                                        <div class="form-outline mb-4">
                                            <select name="idKH" class="form-control form-control-lg"  id="gender">
                                                <option value="0">Trống</option>
                                                <%
                                                    ArrayList<Customers> listCustomers = DAO.Home.getCustomers();
                                                    for (Customers dtoKH : listCustomers) {
                                                %>
                                                <option value="<%= dtoKH.getIdKH()%>"><%= dtoKH.getTenKH()%></option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Tháng thuê</h6>
                                        <div class="form-outline mb-4">
                                            <select name="ThangThue" class="form-control form-control-lg"  id="Thangthue">
                                                <%
                                                    for (int i = 0; i <= 12; i++) {
                                                        if (i == 0) {
                                                %>
                                                <option value="0">Trống</option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%= i%>"><%= i%></option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Giá thuê</h6>
                                        <div class="form-outline mb-4">
                                            <input name="GiaThue" type="number" id="typeEmailX-2" class="form-control form-control-lg" placeholder="Giá Thuê" value="0" required pattern="^[1-9]\d*$" title="Giá Tiền phải là số dương"/>
                                        </div>
                                        <h6 class="m-0 font-weight-bold text-primary">Trạng Thái</h6>
                                        <div class="form-outline mb-4">
                                            <select name="trangThai" class="form-control form-control-lg"  id="gender">
                                                <option value="1">Được Thuê</option>
                                                <option value="2">Trống</option>
                                                <option value="3">Đang sửa chữa</option>
                                            </select>
                                        </div>
                                        <button class="btn btn-primary btn-lg btn-block" type="submit" name="type" value="add">Thêm</button>
                                        <%
                                            }
                                        %>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2020</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Bạn muốn Đăng Xuất ?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Chọn Đăng Xuất bên dưới nếu muốn kết thúc phiên đăng nhập.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Hủy</button>
                        <a class="btn btn-primary" href="Login.jsp">Đăng Xuất</a>
                    </div>
                </div>
            </div>
        </div>



        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>

    </body>

</html>