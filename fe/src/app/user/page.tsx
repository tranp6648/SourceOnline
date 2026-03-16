"use client";
import Sidebar from "@/components/Sidebar";
import TopHeader from "@/components/TopHeader";
import StatsCard from "@/components/user/StatsCard";
import TableFilter from "@/components/user/TableFilter";
import DataTable from "@/ui/DataTable";
import { Download, UserPlus } from "lucide-react";

const columns = [
  { key: "name", title: "User" },
  { key: "role", title: "Role" },
  { key: "status", title: "Status" },
  { key: "date", title: "Join Date" },
];
const users = [
  {
    name: "Sarah Johnson",
    role: "Student",
    status: "Active",
    date: "Oct 12, 2023",
  },
  {
    name: "Dr. Michael Chen",
    role: "Instructor",
    status: "Active",
    date: "Jan 05, 2023",
  },
  {
    name: "Marcus Thompson",
    role: "Student",
    status: "Suspended",
    date: "Feb 28, 2024",
  },
];
export default function UsersPage() {
  return (
    <div className="flex bg-[#F8F9FA] min-h-screen">
      <Sidebar />
      <div className="flex-1 ml-64 min-h-screen">
        <TopHeader />
        <main className="p-8 space-y-6 bg-gray-50 min-h-screen">
          <div className="flex items-start justify-between">
            <div>
              <h1 className="text-2xl font-bold text-gray-900">
                User Directory
              </h1>

              <p className="text-gray-500 text-sm mt-1">
                Manage, filter and export your student and instructor directory.
              </p>
            </div>
            <div className="flex items-center gap-3">
              <button className="flex items-center gap-2 cursor-pointer border border-gray-200 rounded-lg px-4 py-2 text-sm hover:bg-gray-50">
                <Download size={16}/>
                Export CSV
              </button>

              <button className="flex items-center gap-2 px-4 py-2 bg-blue-600 cursor-pointer text-white rounded-lg text-sm font-bold hover:bg-blue-700 transition-all shadow-sm">
                <UserPlus size={16}/>
                Add User
              </button>
            </div>
          </div>

          <div className="grid grid-cols-4 gap-4">
            <StatsCard title="Total Users" value="12,482" change="+4.5%" />
            <StatsCard title="Student" value="11,940" />
            <StatsCard title="Instructors" value="542" />
            <StatsCard title="Active now" value="892" />
          </div>
          <TableFilter />
          <DataTable columns={columns} data={users} />
        </main>
      </div>
    </div>
  );
}
