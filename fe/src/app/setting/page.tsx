import Sidebar from "@/components/Sidebar";
import TopHeader from "@/components/TopHeader";
import {
  Bell,
  Moon,
  Palette,
  Pencil,
  Settings,
  Shield,
  Upload,
} from "lucide-react";

export default function SettingsPage() {
  return (
   <div className="flex bg-[#F8F9FA] min-h-screen">
    <Sidebar/>
    <div className="flex-1 ml-64 min-h-screen">
      <TopHeader/>
       <div className="p-8 bg-gray-50 min-h-screen space-y-6">
      <div>
        <h1 className="text-2xl font-bold text-gray-900">Settings</h1>
        <p className="text-sm text-gray-500">
          Configure your platform settings and administrative preferences.
        </p>
      </div>
      <div className="flex gap-6 border-b border-gray-200 ">
        <button className="flex items-center gap-2 text-blue-600 border-b-2 border-blue-600 pb-2 text-sm font-medium">
          <Settings size={16} /> General
        </button>
        <button className="flex items-center gap-2 text-gray-500 text-sm">
          <Palette size={16} /> Appearance
        </button>
        <button className="flex items-center gap-2 text-gray-500 text-sm">
          <Bell size={16} /> Notifications
        </button>
        <button className="flex items-center gap-2 text-gray-500 text-sm">
          <Shield size={16} /> Security
        </button>
      </div>
      <div className="grid grid-cols-3 gap-6">
        <div className="col-span-2 space-y-6">
          <div className="bg-white border border-gray-200 rounded-xl p-6 space-y-4">
            <div>
              <h3 className="font-semibold text-gray-800">
                Site Configuration
              </h3>
              <p className="text-sm text-gray-500">
                Basic identification for your LearnHub instance.
              </p>
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div>
                <label className="text-xs text-gray-500">Site Name</label>
                <input
                  className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                  defaultValue="LearnHub Global"
                />
              </div>
              <div>
                <label className="text-xs text-gray-500">Support Email</label>
                <input
                  className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                  defaultValue="support@learnhub.com"
                />
              </div>
            </div>
            <div>
              <label className="text-xs text-gray-500">Logo Upload</label>
              <div
                className="border-2 border-dashed border-gray-200 rounded-lg
                p-8 text-center mt-2"
              >
                <Upload className="mx-auto text-gray-400" size={28} />
                <p className="text-sm text-gray-500 mt-2">
                  <span className="text-blue-600 font-medium">
                    Upload a file
                  </span>{" "}
                  or drag and drop
                </p>

                <p className="text-xs text-gray-400">PNG, JPG up to 10MB</p>
              </div>
            </div>
          </div>
          <div className="bg-white border border-gray-200 rounded-xl p-6 space-y-4">
            <div>
              <h3 className="font-semibold text-gray-800">
                SMTP & Email Settings
              </h3>
              <p className="text-sm text-gray-500">
                Configure how the system sends automated emails.
              </p>
            </div>
            <div className="grid grid-cols-2 gap-4">
              <div>
                <label className="text-xs text-gray-500">SMTP Host</label>

                <input
                  className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                  placeholder="smtp.sendgrid.net"
                />
              </div>
              <div>
                <label className="text-xs text-gray-500">Port</label>
                <input
                  className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                  placeholder="587"
                />
              </div>
              <div>
                <label className="text-xs text-gray-500">SMTP UserName</label>
                <input className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm" />
              </div>
              <div>
                <label className="text-xs text-gray-500">SMTP Password</label>

                <input
                  type="password"
                  className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                  defaultValue="password"
                />
              </div>
            </div>
          </div>
        </div>
        <div className="space-y-6">
          <div className="bg-white border border-gray-200 rounded-xl overflow-hidden">
            <div className="px-6 py-4 border-b border-gray-100">
              <h3 className="font-semibold text-gray-800">Admin Profile</h3>
            </div>
            <div className="p-6 text-center">
              <div className="relative w-20 h-20 mx-auto">
                <img
                  src="https://i.pravatar.cc/150"
                  className="w-20 h-20 rounded-full border-4 border-blue-100"
                />
                <button className="absolute bottom-0 right-0 bg-blue-600 text-white p-1.5 rounded-full">
                  <Pencil size={14} />
                </button>
              </div>
              <h4 className="mt-3 font-semibold text-gray-800">Alex Rivera</h4>
              <p className="text-sm text-gray-500">Joined June 2023</p>
              <div className="mt-4 space-y-3 text-left">
                <div>
                  <label className="text-xs text-gray-500">Full Name</label>
                  <input
                    className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                    placeholder="Alex Rivera"
                  />
                </div>
                <div>
                  <label className="text-xs text-gray-500">Position</label>
                  <input
                    className="w-full border border-gray-200 rounded-lg px-3 py-2 text-sm"
                    placeholder="Super Admn"
                  />
                </div>
                <button className="w-full bg-slate-100 hover:bg-slate text-slate-700 cursor-pointer font-bold py-2 rounded-lg text-sm">
                  Update Profile
                </button>
              </div>
            </div>
          </div>
          <div className="bg-blue-50 border border-blue-200 rounded-xl p-5">
            <h4 className="font-semibold text-blue-900">Need help?</h4>

            <p className="text-sm text-blue-700 mt-1">
              Need assistance with your configuration? Visit our Documentation
              or contact support.
            </p>
          </div>
          <div
            className="flex items-center justify-between bg-white border border-gray-200 rounded-xl
          px-5 py-4"
          >
            <div className="flex items-center gap-2 text-gray-200">
              <Moon size={16} />
              <span className="text-sm">Dark Mode</span>
            </div>
            <button className="w-10 h-5 bg-gray-200 rounded-full relative">
              <span className="absolute left-1 top-1 w-3 h-3 bg-white rounded-full"></span>
            </button>
          </div>
        </div>
      </div>
    </div>
    </div>
   </div>
  );
}
