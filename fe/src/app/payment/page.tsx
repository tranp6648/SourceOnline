import PaymentFilter from "@/components/payment/PaymentFilter";
import Sidebar from "@/components/Sidebar";
import TopHeader from "@/components/TopHeader";
import DataTable from "@/ui/DataTable";
import {
  Calendar,
  Clock,
  DollarSign,
  Download,
  TrendingUp,
} from "lucide-react";

export default function PaymentPage() {
  const columns = [
    { key: "transaction", title: "Transaction" },
    { key: "user", title: "User" },
    { key: "amount", title: "Amount" },
    { key: "date", title: "Date" },
    { key: "method", title: "Method" },
    { key: "status", title: "Status" },
  ];
  const data = [
    {
      transaction: <span className="text-blue-600">#TRX-94821</span>,

      user: (
        <div className="flex items-center gap-2">
          <img
            src="https://i.pravatar.cc/40"
            className="w-8 h-8 rounded-full"
          />
          <div>
            <p className="font-medium text-gray-800">Alex Johnson</p>
            <p className="text-xs text-gray-400">alex@email.com</p>
          </div>
        </div>
      ),

      amount: "$149.00",

      date: (
        <div>
          <p>Oct 24</p>
          <p className="text-xs text-gray-400">2023</p>
        </div>
      ),

      method: <span className="text-sm text-gray-600">Visa ****4242</span>,

      status: (
        <span className="bg-green-100 text-green-600 px-2 py-1 rounded text-xs font-medium">
          SUCCESS
        </span>
      ),
    },

    {
      transaction: <span className="text-blue-600">#TRX-94818</span>,

      user: (
        <div className="flex items-center gap-2">
          <img
            src="https://i.pravatar.cc/41"
            className="w-8 h-8 rounded-full"
          />
          <div>
            <p className="font-medium text-gray-800">Sarah Chen</p>
            <p className="text-xs text-gray-400">sarah@email.com</p>
          </div>
        </div>
      ),

      amount: "$89.00",

      date: (
        <div>
          <p>Oct 23</p>
          <p className="text-xs text-gray-400">2023</p>
        </div>
      ),

      method: "PayPal",

      status: (
        <span className="bg-red-100 text-red-600 px-2 py-1 rounded text-xs font-medium">
          FAILED
        </span>
      ),
    },
  ];
  return (
    <div className="flex bg-[#F8F9FA] min-h-screen">
      <Sidebar />
      <div className="flex-1 ml-64 min-h-screen">
        <TopHeader />
        <main className="p-8 space-y-6 bg-gray-50 min-h-screen">
          <div className="p-8  min-h-screen space-y-6">
            <div className="flex items-center justify-between">
              <div>
                <h1 className="text-2xl font-bold text-gray-900">Payments</h1>
                <p className="text-sm text-gray-500">
                  Manage your revenue and transaction history across all
                  platforms.
                </p>
              </div>
              <div className="flex gap-3">
                <button className="flex items-center gap-2 border border-blue-200 bg-white rounded-lg px-4 py-2 text-sm hover:bg-blue-50">
                  <Calendar size={16} />
                  Oct 1, 2023 - Oct 31, 2023
                </button>

                <button className="flex items-center gap-2 bg-blue-600 text-white rounded-lg px-4 py-2 text-sm hover:bg-blue-700">
                  <Download size={16} />
                  Export Report
                </button>
              </div>
            </div>
            <div className="grid grid-cols-3 gap-6">
              <div className="bg-white border border-blue-100 rounded-xl p-6 shadow-sm">
                <div className="flex items-center justify-between">
                  <div className="p-3 bg-blue-100 rounded-lg">
                    <DollarSign className="text-blue-600" />
                  </div>
                  <span className="text-green-500 text-sm font-medium">
                    +12.5%
                  </span>
                </div>
                <p className="text-sm text-gray-500 mt-4">TOTAL REVENUE</p>
                <h3 className="text-2xl font-bold text-gray-900">$45,230.00</h3>
              </div>
              <div className="bg-white border border-blue-100 rounded-xl p-6 shadow-sm">
                <div className="flex items-center justify-between">
                  <div className="p-3 bg-blue-100 rounded-lg">
                    <TrendingUp className="text-blue-600" />
                  </div>
                  <span className="text-green-500 text-sm font-medium">
                    +8.2%
                  </span>
                </div>
                <p className="text-sm text-gray-500 mt-4">NEXT PROFIT</p>
                <h3 className="text-2xl font-bold text-gray-900">$38,120.50</h3>
              </div>
              <div className="bg-white border border-blue-100 rounded-xl p-6 shadow-sm">
                <div className="flex items-center justify-between">
                  <div className="p-3 bg-blue-100 rounded-lg">
                    <Clock className="text-blue-600" />
                  </div>
                  <span className="text-red-500 text-sm font-medium">
                    -2.1%
                  </span>
                </div>

                <p className="text-sm text-gray-500 mt-4">PENDING PAYOUTS</p>
                <h3 className="text-2xl font-bold text-gray-900">$2,400.00</h3>
              </div>
            </div>
            <div className="bg-white border border-blue-100 rounded-xl p-6 space-y-4">
              <PaymentFilter />
              <DataTable columns={columns} data={data} />
            </div>
          </div>
        </main>
      </div>
    </div>
  );
}
